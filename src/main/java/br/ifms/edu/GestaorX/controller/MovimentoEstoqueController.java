package br.ifms.edu.GestaorX.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifms.edu.GestaorX.service.MovimentoEstoqueService;

@Service
@RestController
@RequestMapping("/movimento_estoque")
public class MovimentoEstoqueController {

    private final MovimentoEstoqueService service;

    public MovimentoEstoqueController(MovimentoEstoqueService service) {
        this.service = service;
    }
}
