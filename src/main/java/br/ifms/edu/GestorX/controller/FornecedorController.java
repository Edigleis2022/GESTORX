package br.ifms.edu.GestorX.controller;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifms.edu.GestorX.dto.FornecedorDTO;
import br.ifms.edu.GestorX.model.Fornecedor;
import br.ifms.edu.GestorX.service.FornecedorService;

@RestController // Define que essa classe é um controller REST (retorna JSON)
@RequestMapping("/fornecedores") // Rota base da API
public class FornecedorController {

    private final FornecedorService service;

    // Injeção de dependência via construtor
    public FornecedorController(FornecedorService service) {
        this.service = service;
    }

    @PostMapping
    public Fornecedor salvar(@RequestBody Fornecedor fornecedor) {
        // Recebe um fornecedor no corpo da requisição (JSON)
        // e salva no banco através do service
        return service.salvar(fornecedor);
    }

    @GetMapping
    public List<FornecedorDTO> listar() {
        // Retorna a lista de fornecedores (usando DTO)
        return service.listar();
    }

    @PutMapping("/{fornecedorId}/produtos/{produtoId}/encerrar")
    public void encerrarVinculo(
        @PathVariable Long forncecedorId,
        @PathVariable Long produtoId) {
        
        // Remove (ou encerra) o vínculo entre fornecedor e produto
        // baseado nos IDs informados na URL
        service.encerrarVinculo(forncecedorId, produtoId);
    }

    @GetMapping("/{id}")
    public FornecedorDTO buscarPorId(@PathVariable Long id) {
        // Busca um fornecedor específico pelo ID
        // e retorna como DTO
        return service.buscarPorId(id);
    }
}
