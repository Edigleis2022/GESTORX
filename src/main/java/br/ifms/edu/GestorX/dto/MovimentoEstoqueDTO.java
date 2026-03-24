package br.ifms.edu.GestorX.dto;

import lombok.Data;
@Data
public class MovimentoEstoqueDTO {

    private Long id;
    private String tipomovimentacao;
    private Integer quantidade;
}
