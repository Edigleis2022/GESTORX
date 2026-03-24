package br.ifms.edu.GestorX.controller;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.ifms.edu.GestorX.model.MovimentoEstoque;
import br.ifms.edu.GestorX.service.MovimentoEstoqueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Service
@RestController
@RequestMapping("/movimento_estoque")
public class MovimentoEstoqueController {

    private final MovimentoEstoqueService service;

    public MovimentoEstoqueController(MovimentoEstoqueService service) {
        this.service = service;
    }

    @PostMapping
    public MovimentoEstoque salvar(@RequestBody MovimentoEstoque movimentoEstoque) {
        return service.salvar(movimentoEstoque);
    }

    @GetMapping
    public List<MovimentoEstoque> listar(){
        return service.listar();
    }
    
}
