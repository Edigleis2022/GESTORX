package br.ifms.edu.GestaorX.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class VendaDTO {

    private Long id;
    private LocalDate dataVenda;
    private Double valorTotal;
}
