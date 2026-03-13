package br.ifms.edu.GestaorX.service.implementacao;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ifms.edu.GestaorX.dto.FornecedorDTO;
import br.ifms.edu.GestaorX.model.Fornecedor;
import br.ifms.edu.GestaorX.repository.FornecedorRepository;
import br.ifms.edu.GestaorX.service.FornecedorService;

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
        return repository.findAll().stream().map(FornecedorDTO).toList();
    }

}
