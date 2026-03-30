package br.ifms.edu.GestorX.service;

import java.util.List;
import br.ifms.edu.GestorX.dto.FornecedorDTO;
import br.ifms.edu.GestorX.model.Fornecedor;


public interface FornecedorService {

    //Salva Fornecedor
    Fornecedor salvar(Fornecedor fornecedor);

    // Listar
    List<FornecedorDTO> listar(); //Lista usando DTO

    // Buscar por ID
    FornecedorDTO buscarPorId(Long id);

    //Deletar (inativar)
    void deletar(Long id);
    
    // Atualizar (retorna DTO))
    FornecedorDTO atualizar(Long id, Fornecedor fornecedor);

    // Encerrar vínculo 
    void encerrarVinculo(Long fornecedorId, Long produtoId);

}
