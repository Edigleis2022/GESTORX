package br.ifms.edu.GestorX.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Teste de integração do cadastro de usuário.
 *
 * Fluxo:
 *
 * MockMvc
 * ↓
 * UsuarioController
 * ↓
 * UsuarioServiceImpl
 * ↓
 * UsuarioRepository
 * ↓
 * PostgreSQL
 */
@SpringBootTest
@AutoConfigureMockMvc
class UsuarioControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCadastrarUsuario() throws Exception {

        // Gera um identificador diferente a cada execução do teste.
        // Assim, não teremos conflito de CPF ou e-mail no banco.
        String identificador = String.valueOf(System.currentTimeMillis());

        // O CPF precisa ter entre 11 e 14 caracteres.
        // Pegamos os últimos 11 números do identificador.
        String cpf = identificador.substring(identificador.length() - 11);

        // O e-mail também precisa ser único.
        String email = "integracao." + identificador + "@teste.com";

        // Monta o JSON que será enviado para a API.
        String json = """
                {
                    "nome": "Usuario Integracao",
                    "email": "%s",
                    "senha": "Teste@123",
                    "tipoUsuario": "ADMIN",
                    "cpf": "%s",
                    "cargo": "Gerente",
                    "estabelecimento": "Mercado Teste"
                }
                """.formatted(email, cpf);

        // Executa o POST /usuarios.
        String resposta = mockMvc.perform(
                post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))

                // Esperamos HTTP 201 CREATED.
                .andExpect(status().isCreated())

                // Guarda a resposta da API.
                .andReturn()
                .getResponse()
                .getContentAsString();

        // Converte a resposta JSON para facilitar as verificações.
        JsonNode usuario = objectMapper.readTree(resposta);

        // Verifica se o usuário realmente foi criado.
        assertNotNull(usuario.get("id"));

        // Verifica os dados retornados pela API.
        assertEquals("Usuario Integracao", usuario.get("nome").asText());
        assertEquals(email, usuario.get("email").asText());

        // A senha NÃO deve ser retornada pelo DTO.
        assertTrue(usuario.get("senha") == null);
    }
}
