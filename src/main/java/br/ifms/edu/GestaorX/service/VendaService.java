package br.ifms.edu.GestaorX.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.ifms.edu.GestaorX.model.Venda;

@Service
public interface VendaService {

    Venda salvar(Venda venda);
    List<Venda> listar();

}
