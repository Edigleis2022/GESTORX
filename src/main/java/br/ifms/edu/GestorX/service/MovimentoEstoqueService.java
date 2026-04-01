package br.ifms.edu.GestorX.service;

import java.util.List;
import org.springframework.stereotype.Service;

import br.ifms.edu.GestorX.dto.MovimentoEstoqueDTO;
import br.ifms.edu.GestorX.model.MovimentoEstoque;

@Service
public interface MovimentoEstoqueService {

    MovimentoEstoque realizarMovimento(MovimentoEstoqueDTO dto);

    MovimentoEstoque salvar(MovimentoEstoque movimentoEstoque);
    
    List<MovimentoEstoque> listar();
}
