package br.ifms.edu.GestaorX.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifms.edu.GestaorX.model.RelatorioVenda;
import br.ifms.edu.GestaorX.service.RelatorioVendaService;

@RestController
@RequestMapping("/relatorio_venda")
public class RelatorioVendaController {

    private final RelatorioVendaService service;

    public RelatorioVendaController(RelatorioVendaService service){
        this.service = service;
    }

    @PostMapping
    public RelatorioVenda salvar(@RequestBody RelatorioVenda relatorioVenda){
        return service.salvar(relatorioVenda);
    }

    @GetMapping
    public List<RelatorioVenda> listar(){
        return service.listar();
    }
        
}
