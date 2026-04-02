package br.ifms.edu.GestorX.dto;

import br.ifms.edu.GestorX.model.Produto;
import lombok.Data;


@Data
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String categoria;
    private Integer quantidade;
    private Double preco;

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.categoria = produto.getCategoria() != null 
        ? produto.getCategoria()
        .name() 
        : null;
        this.quantidade = produto.getQuantidade();
    }
}
