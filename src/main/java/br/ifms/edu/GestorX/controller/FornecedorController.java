package br.ifms.edu.GestorX.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public FornecedorDTO salvar(@RequestBody Fornecedor fornecedor) {
        
        // Recebe um fornecedor no corpo da requisição (JSON)
        // e salva no banco através do service
        return new FornecedorDTO( service.salvar(fornecedor));
    }

    @GetMapping
    public List<FornecedorDTO> listar() {
        // Retorna a lista de fornecedores (usando DTO)
        return service.listar();
    }

    @PutMapping("/{fornecedorId}/produtos/{produtoId}/encerrar")
    public void encerrarVinculo(
        @PathVariable Long fornecedorId,
        @PathVariable Long produtoId) {
        
        // Remove (ou encerra) o vínculo entre fornecedor e produto
        // baseado nos IDs informados na URL
        service.encerrarVinculo(fornecedorId, produtoId);
    }

    @GetMapping("/{id}")
    public FornecedorDTO buscarPorId(@PathVariable Long id) {
        // Busca um fornecedor específico pelo ID
        // e retorna como DTO
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public FornecedorDTO atualizar(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        // Atualiza um fornecedor existente com os dados fornecidos
        // e retorna o fornecedor atualizado como DTO
        return service.atualizar(id, fornecedor);
    }

    @DeleteMapping("/{id}/deletar")
    public void deletar(@PathVariable Long id) {
        // "Deleta" um fornecedor (na verdade, inativa)
        service.deletar(id);
    }
}
