package br.ifms.edu.GestaorX.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ifms.edu.GestaorX.model.Estoque;

@Service
public interface EstoqueService {

     Estoque salvar(Estoque estoque);

    List<Estoque> listar();

    
}
