package br.ifms.edu.GestaorX.service;

import java.util.List;
import br.ifms.edu.GestaorX.model.RelatorioVenda;

public interface RelatorioVendaService {
    
    RelatorioVenda salvar (RelatorioVenda relatorioVenda);
    List<RelatorioVenda>listar();
}
