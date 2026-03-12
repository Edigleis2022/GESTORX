package br.ifms.edu.GestaorX.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ifms.edu.GestaorX.model.MovimentoEstoque;

@Service
public interface MovimentoEstoqueService {

    MovimentoEstoque salvar(MovimentoEstoque movimentoEstoque);
    List<MovimentoEstoque> listar();
}
