package br.ifms.edu.GestaorX.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ifms.edu.GestaorX.dto.ProdutoDTO;
import br.ifms.edu.GestaorX.model.Produto;

@Service
public interface ProdutoService {
    Produto salvar(Produto produto);
    List<ProdutoDTO> listar();
}
