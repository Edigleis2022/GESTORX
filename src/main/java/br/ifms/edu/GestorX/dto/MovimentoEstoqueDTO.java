package br.ifms.edu.GestorX.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class MovimentoEstoqueDTO {

    @NotNull
    private Long id;

    @NotNull
    @Min(1)
    private String tipomovimentacao;
    
    private Integer quantidade;
}
