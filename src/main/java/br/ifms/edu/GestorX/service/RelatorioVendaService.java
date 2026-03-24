package br.ifms.edu.GestorX.service;

import java.util.List;
import br.ifms.edu.GestorX.model.RelatorioVenda;

public interface RelatorioVendaService {
    
    RelatorioVenda salvar (RelatorioVenda relatorioVenda);
    List<RelatorioVenda>listar();
}
