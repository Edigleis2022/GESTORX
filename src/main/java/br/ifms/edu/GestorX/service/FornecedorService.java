package br.ifms.edu.GestorX.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.ifms.edu.GestorX.dto.FornecedorDTO;
import br.ifms.edu.GestorX.model.Fornecedor;

@Service
public interface FornecedorService {

    Fornecedor salvar(Fornecedor fornecedor);
    List<FornecedorDTO> listar();
}
