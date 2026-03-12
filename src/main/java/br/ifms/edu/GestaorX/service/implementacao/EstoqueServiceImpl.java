package br.ifms.edu.GestaorX.service.implementacao;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ifms.edu.GestaorX.model.Estoque;
import br.ifms.edu.GestaorX.repository.EstoqueRepository;
import br.ifms.edu.GestaorX.service.EstoqueService;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    private final EstoqueRepository repository;

    public EstoqueServiceImpl(EstoqueRepository repository) {
        this.repository = repository;
    }

    public Estoque salvar(Estoque estoque) {
        return repository.save(estoque);
    }

    public List<Estoque> listar() {
        return repository.findAll();
    }
}
