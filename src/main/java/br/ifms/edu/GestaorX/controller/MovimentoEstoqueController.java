package br.ifms.edu.GestaorX.controller;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifms.edu.GestaorX.model.Venda;
import br.ifms.edu.GestaorX.service.MovimentoEstoqueService;

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
    public Venda salvar(@RequestBody Venda venda) {
        return service.salvar(venda);
    }

    @GetMapping
    public List<Venda> listar(){
        return service.listar();
    }
    
}
