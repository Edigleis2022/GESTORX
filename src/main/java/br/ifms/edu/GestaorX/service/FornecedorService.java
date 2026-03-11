package br.ifms.edu.GestaorX.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ifms.edu.GestaorX.dto.FornecedorDTO;
import br.ifms.edu.GestaorX.model.Fornecedor;

@Service
public interface FornecedorService {

    Fornecedor salvar(Fornecedor fornecedor);
    List<FornecedorDTO> listar();
}
