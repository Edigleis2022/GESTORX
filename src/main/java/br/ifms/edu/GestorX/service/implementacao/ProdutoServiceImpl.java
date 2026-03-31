package br.ifms.edu.GestorX.service.implementacao;

import java.util.List;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
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

    // 🔹 Método reutilizável (evita repetição)
    private Produto buscarOuFalhar(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto com ID " + id + " não encontrado"));
    }

    // 🔹 Salvar produto
    @Override
    public ProdutoDTO salvar(Produto produto) {

        Produto salvo = repository.save(produto);

        return new ProdutoDTO(salvo);
    }

    // 🔹 Listar todos
    @Override
    public List<ProdutoDTO> listar() {

        return repository.findAll()
                .stream()
                .map(ProdutoDTO::new)
                .toList();
    }

    // 🔹 Buscar por ID
    @Override
    public ProdutoDTO buscarPorId(Long id) {

        Produto produto = buscarOuFalhar(id);

        return new ProdutoDTO(produto);
    }

    // 🔹 Atualizar produto
    @Override
    public ProdutoDTO atualizar(Long id, Produto produtoAtualizado) {

        Produto produto = buscarOuFalhar(id);

        produto.setNome(produtoAtualizado.getNome());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setQuantidade(produtoAtualizado.getQuantidade());
        produto.setCategoria(produtoAtualizado.getCategoria());

        Produto atualizado = repository.save(produto);

        return new ProdutoDTO(atualizado);
    }

    // 🔹 Deletar produto
    @Override
    public void deletar(Long id) {

        Produto produto = buscarOuFalhar(id);

        repository.delete(produto);
    }
}
 