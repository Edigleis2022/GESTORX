package br.ifms.edu.GestaorX.dto;


import br.ifms.edu.GestaorX.model.MovimentoEstoque;
import lombok.Data;
@Data
public class MovimentoEstoqueDTO {

    private Long id;
    private String tipomovimentacao;
    private Integer quantidade;
}
