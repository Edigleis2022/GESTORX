package br.ifms.edu.GestaorX.service.implementacao;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ifms.edu.GestaorX.dto.ProdutoDTO;
import br.ifms.edu.GestaorX.model.Produto;
import br.ifms.edu.GestaorX.repository.ProdutoRepository;
import br.ifms.edu.GestaorX.service.ProdutoService;

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
        return repository.findAll().stream().map(ProdutoDTO::new).toList();
    }

}
