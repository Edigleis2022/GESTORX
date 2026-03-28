package br.ifms.edu.GestorX.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.ifms.edu.GestorX.dto.ProdutoDTO;
import br.ifms.edu.GestorX.model.Produto;
import br.ifms.edu.GestorX.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    //Adaptado para Receber uma lista
    @PostMapping("/lote")
    public List<Produto> salvarVarios(@RequestBody List<Produto> produtos) {
        return produtos.stream()
                .map(service::salvar)
                .toList();
    }

    @GetMapping
    public List<ProdutoDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
