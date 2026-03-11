package br.ifms.edu.GestaorX.dto;

import br.ifms.edu.GestaorX.model.Fornecedor;

public class FornecedorDTO {

    private Long id;
    private String nome;

    public FornecedorDTO(Fornecedor fornecedor) {
        this.id = fornecedor.getId();
        this.nome = fornecedor.getNome();
    }
}
