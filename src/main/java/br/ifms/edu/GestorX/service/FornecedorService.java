package br.ifms.edu.GestorX.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.ifms.edu.GestorX.dto.FornecedorDTO;
import br.ifms.edu.GestorX.model.Fornecedor;

@Service
public interface FornecedorService {

    //Salva Fornecedor
    Fornecedor salvar(Fornecedor fornecedor);
    List<FornecedorDTO> listar(); //Lista usando DTO

    // Buscar por ID
    Fornecedor buscarPorId(Long id);

    //Deletar
    void deletar(Long id);
        
    Fornecedor atualizar(Long id, Fornecedor fornecedor);
    
}
