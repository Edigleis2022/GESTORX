package br.ifms.edu.GestaorX.dto;

import br.ifms.edu.GestaorX.model.Produto;
import lombok.Data;


@Data
public class ProdutoDTO {

    private Long id;
    private String nome;
    private Double preco;
}
