package br.ifms.edu.GestorX.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.ifms.edu.GestorX.model.Venda;

@Service
public interface VendaService {

    Venda salvar(Venda venda);
    List<Venda> listar();

}
