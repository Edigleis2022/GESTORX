package br.ifms.edu.GestorX.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.ifms.edu.GestorX.dto.ProdutoDTO;
import br.ifms.edu.GestorX.model.Produto;

@Service
public interface ProdutoService {
    Produto salvar(Produto produto);
    List<ProdutoDTO> listar();
    
    public Produto buscarPorId(Long id);

    void deletar (Long id);

    Produto atualizar(Long id, Produto produto);
    
}
