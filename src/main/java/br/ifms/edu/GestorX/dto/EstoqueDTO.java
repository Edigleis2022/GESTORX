package br.ifms.edu.GestorX.dto;

import br.ifms.edu.GestorX.model.Estoque;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EstoqueDTO {

    private Long id;
    private Integer quantidade;
    private String status;
    private String nomeProduto;

    public EstoqueDTO(Estoque estoque) {
        this.id = estoque.getId();
        this.quantidade = estoque.getQuantidade();
        this.status = estoque.getStatus().name();
        this.nomeProduto = estoque.getProduto().getNome();
    }
}
