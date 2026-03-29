package br.ifms.edu.GestorX.service.implementacao;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import br.ifms.edu.GestorX.dto.FornecedorDTO;
import br.ifms.edu.GestorX.model.Fornecedor;
import br.ifms.edu.GestorX.repository.FornecedorRepository;
import br.ifms.edu.GestorX.service.FornecedorService;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    private final FornecedorRepository repository;

    public FornecedorServiceImpl(FornecedorRepository repository) {
        this.repository = repository;
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public List<FornecedorDTO> listar() {
        return repository.findAll().stream()
                .map((Fornecedor entity) -> {
                    FornecedorDTO dto = new FornecedorDTO();
                    dto.setId(entity.getId());
                    dto.setNome(entity.getNome());
                    dto.setEmail(entity.getEmail());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Fornecedor buscarPorId(Long id) {

        // Busca forncecedor pelo ID
        return repository.findById(id)
                // Se não encontrar, lança erro
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    @Override
    public void deletar(Long id) {
        // Verifica se o fornecedor existe
        Fornecedor fornecedor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        // Deleta o fornecedor
        repository.delete(fornecedor);
    }

}
