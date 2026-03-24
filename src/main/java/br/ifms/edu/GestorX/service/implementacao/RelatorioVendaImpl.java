package br.ifms.edu.GestorX.service.implementacao;

import java.util.List;
import org.springframework.stereotype.Service;
import br.ifms.edu.GestorX.model.RelatorioVenda;
import br.ifms.edu.GestorX.repository.RelatorioVendaRepository;
import br.ifms.edu.GestorX.service.RelatorioVendaService;

@Service
public class RelatorioVendaImpl implements RelatorioVendaService {

    private final RelatorioVendaRepository repository;
    
    public RelatorioVendaImpl(RelatorioVendaRepository repository) {
        this.repository = repository;
    }

    public RelatorioVenda salvar(RelatorioVenda relatorioVenda){
        return repository.save(relatorioVenda);
    }

    public List<RelatorioVenda>listar(){
        return repository.findAll();
    }
}
