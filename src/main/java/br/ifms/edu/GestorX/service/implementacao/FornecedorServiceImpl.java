package br.ifms.edu.GestorX.service.implementacao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import br.ifms.edu.GestorX.dto.FornecedorDTO;
import br.ifms.edu.GestorX.model.Fornecedor;
import br.ifms.edu.GestorX.model.FornecedorProduto;
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

    @Override
    public Fornecedor atualizar(Long id, Fornecedor fornecedor) {

        // Verifica se o fornecedor existe
        Fornecedor existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        // Atualiza os campos do fornecedor existente
        existente.setNome(fornecedor.getNome());
        existente.setEmail(fornecedor.getEmail());
        existente.setTelefone(fornecedor.getTelefone());
        existente.setEndereco(fornecedor.getEndereco());
        existente.setStatus(fornecedor.getStatus());

        // Salva as alterações
        return repository.save(existente);
    }

    public void encerrarVinculo(Long fornecedorId, Long produtoId) {

        // . Buscar forneced
        Fornecedor fornecedor = repository.findById(fornecedorId)
            .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

            // 2. Percorrer os vínculos
            for (FornecedorProduto fp : fornecedor.getFornecedorProdutos()) {
                if (fp.getProduto().getId().equals(produtoId)) {
                    // 3. Encerrar o vínculo
                    fp.setDataFim(LocalDate.now());
                    break;
                }
            }
            // 5 .Salvar fornecedor (atualiza tudo)
            repository.save(fornecedor);
    }

    


}
