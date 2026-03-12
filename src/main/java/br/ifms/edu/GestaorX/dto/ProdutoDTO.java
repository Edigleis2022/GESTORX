package br.ifms.edu.GestaorX.dto;

import br.ifms.edu.GestaorX.model.Produto;
import lombok.Data;


@Data
public class ProdutoDTO {

    private Long id;
    private String nome;
    private Double preco;

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
    }
}
