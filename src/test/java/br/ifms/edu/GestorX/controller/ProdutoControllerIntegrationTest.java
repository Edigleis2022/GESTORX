package br.ifms.edu.GestorX.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.springframework.security.test.context.support.WithMockUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Teste de integração do cadastro de produto.
 *
 * Diferente do teste unitário, aqui levantamos a aplicação Spring.
 *
 * Fluxo testado:
 *
 * MockMvc
 * ↓
 * ProdutoController
 * ↓
 * ProdutoService
 * ↓
 * ProdutoRepository
 * ↓
 * PostgreSQL
 */
@SpringBootTest
@AutoConfigureMockMvc
class ProdutoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(username = "admin@teste.com", roles = "ADMIN")
    void deveCadastrarProduto() throws Exception {

        // Gera um código diferente a cada execução do teste.
        // Isso evita conflito com produtos já existentes no PostgreSQL.
        String codigo = "TESTE" + System.currentTimeMillis();

        // Monta o JSON enviado para a API.
        String json = """
                {
                    "codigo": "%s",
                    "nome": "Produto Teste Integracao",
                    "marca": "Marca Teste",
                    "preco": 25.90,
                    "quantidade": 30,
                    "estoqueMinimo": 5,
                    "categoria": "ALIMENTO"
                }
                """.formatted(codigo);

        // Executa POST /produtos.
        String resposta = mockMvc.perform(
                post("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))

                // O ProdutoController atual retorna 200 OK.
                .andExpect(status().isOk())

                // Guarda o JSON retornado pela API.
                .andReturn()
                .getResponse()
                .getContentAsString();

        // Converte a resposta para JSON.
        JsonNode produto = objectMapper.readTree(resposta);

        // Verifica se o produto foi criado.
        assertNotNull(produto.get("id"));

        // Verifica os principais dados retornados.
        assertEquals("Produto Teste Integracao", produto.get("nome").asText());
        assertEquals(codigo, produto.get("codigo").asText());
    }
}
