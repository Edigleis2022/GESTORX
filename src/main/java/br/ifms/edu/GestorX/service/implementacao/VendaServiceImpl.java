package br.ifms.edu.GestorX.service.implementacao;

import java.util.List;
import org.springframework.stereotype.Service;
import br.ifms.edu.GestorX.model.Venda;
import br.ifms.edu.GestorX.repository.VendaRepository;
import br.ifms.edu.GestorX.service.VendaService;


@Service
public class VendaServiceImpl implements VendaService {

    private final VendaRepository repository;

    public VendaServiceImpl(VendaRepository repository) {
        this.repository = repository;
    }

    public Venda salvar(Venda venda) {
        return repository.save(venda);
    }

    public List<Venda> listar() {
        return repository.findAll();
    }
}
