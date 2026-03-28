package br.ifms.edu.GestorX.service.implementacao;

import java.util.List;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import br.ifms.edu.GestorX.dto.ProdutoDTO;
import br.ifms.edu.GestorX.model.Produto;
import br.ifms.edu.GestorX.repository.ProdutoRepository;
import br.ifms.edu.GestorX.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoServiceImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public List<ProdutoDTO> listar() {
        return repository.findAll()
        .stream()
        .map(ProdutoDTO::new)
        .toList();
    }

    @Override
    public Produto buscarPorId(Long id) {
        //Procura o produto no banco pelo ID
        return repository.findById(id)
            // Se não encontrar, lança um erro
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @Override
    public Produto atualizar(Long id, Produto produtoAtualizado) {

        //1. Buscar o produto que já existe no banco
        Produto produto = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produuto não encontrado"));

        //2. Atualizar os dados do produto encontrado com os novos valores
        produto.setNome(produtoAtualizado.getNome()); 
        produto.setPreco(produtoAtualizado.getPreco()); 
        produto.setQuantidade(produtoAtualizado.getQuantidade());
        produto.setCategoria(produtoAtualizado.getCategoria());

        //3. Salvar o produto atualizado no banco
        return repository.save(produto);
    }

    @Override
    public void deletar(Long id){

        repository.deleteById(id);
    }
} 
 