package br.ifms.edu.GestorX.dto;

import br.ifms.edu.GestorX.model.Fornecedor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FornecedorDTO {

    private Long id;
    private String nome;
    private String email;
    
    //Construtor que converte Entity ->  
    
}
