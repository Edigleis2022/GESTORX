package br.ifms.edu.GestorX.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;

import br.ifms.edu.GestorX.dto.ProdutoDTO;
import br.ifms.edu.GestorX.enums.CategoriaProduto;
import br.ifms.edu.GestorX.model.Produto;
import br.ifms.edu.GestorX.repository.ProdutoRepository;
import br.ifms.edu.GestorX.service.impl.ProdutoServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Testes unitários do ProdutoServiceImpl.
 *
 * O ProdutoRepository é simulado com Mockito.
 * Portanto, estes testes não precisam acessar o PostgreSQL.
 */
@ExtendWith(MockitoExtension.class)
class ProdutoServiceImplTest {

    // Simula o repositório de produtos.
    @Mock
    private ProdutoRepository repository;

    // Classe que estamos testando.
    @InjectMocks
    private ProdutoServiceImpl service;

    private Produto produto;

    /**
     * Cria um produto válido antes de cada teste.
     */
    @BeforeEach
    void setUp() {

        produto = new Produto();

        produto.setId(1L);
        produto.setCodigo("CAF001");
        produto.setNome("Café Torrado");
        produto.setMarca("Melitta");
        produto.setPreco(15.90);
        produto.setQuantidade(50);
        produto.setEstoqueMinimo(10);
        produto.setCategoria(CategoriaProduto.ALIMENTO);
    }

    /**
     * TU04
     *
     * Testa a busca de um produto existente.
     */
    @Test
    void deveBuscarProdutoPorId() {

        // Simula que o produto existe no banco.
        when(repository.findById(1L))
                .thenReturn(Optional.of(produto));

        // Executa o método.
        ProdutoDTO resultado = service.buscarPorId(1L);

        // Verifica se encontrou o produto.
        assertNotNull(resultado);

        // Confirma os dados retornados.
        assertEquals(1L, resultado.getId());
        assertEquals("CAF001", resultado.getCodigo());
        assertEquals("Café Torrado", resultado.getNome());
        assertEquals("Melitta", resultado.getMarca());
        assertEquals(15.90, resultado.getPreco());
        assertEquals(50, resultado.getQuantidade());
        assertEquals(10, resultado.getEstoqueMinimo());
        assertEquals("ALIMENTO", resultado.getCategoria());

        // Confirma que o repositório foi consultado.
        verify(repository).findById(1L);
    }

    /**
     * TU05
     *
     * Testa a busca de um produto que não existe.
     */
    @Test
    void deveFalharQuandoProdutoNaoExistir() {

        // Simula que não encontrou o produto.
        when(repository.findById(99L))
                .thenReturn(Optional.empty());

        // Esperamos RuntimeException.
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.buscarPorId(99L)
        );

        // Confirma a mensagem da exceção.
        assertEquals(
                "Produto com ID 99 não encontrado",
                exception.getMessage()
        );

        // Confirma que o banco foi consultado.
        verify(repository).findById(99L);
    }

    /**
     * TU06
     *
     * Testa a atualização de um produto existente.
     */
    @Test
    void deveAtualizarProduto() {

        // Produto com os novos dados.
        Produto produtoAtualizado = new Produto();

        produtoAtualizado.setCodigo("CAF002");
        produtoAtualizado.setNome("Café Especial");
        produtoAtualizado.setMarca("Melitta");
        produtoAtualizado.setPreco(20.00);
        produtoAtualizado.setQuantidade(100);
        produtoAtualizado.setEstoqueMinimo(20);
        produtoAtualizado.setCategoria(CategoriaProduto.ALIMENTO);

        // Simula a busca do produto existente.
        when(repository.findById(1L))
                .thenReturn(Optional.of(produto));

        // Simula o salvamento do produto atualizado.
        when(repository.save(any(Produto.class)))
                .thenReturn(produto);

        // Executa a atualização.
        ProdutoDTO resultado =
                service.atualizar(1L, produtoAtualizado);

        // Verifica o resultado.
        assertNotNull(resultado);

        // Confirma que os dados foram alterados.
        assertEquals("CAF002", resultado.getCodigo());
        assertEquals("Café Especial", resultado.getNome());
        assertEquals(20.00, resultado.getPreco());
        assertEquals(100, resultado.getQuantidade());
        assertEquals(20, resultado.getEstoqueMinimo());

        // Confirma que o produto foi salvo.
        verify(repository).save(produto);
    }
}
