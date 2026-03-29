package br.ifms.edu.GestorX.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class FornecedorProduto {

    // Entidade Intermediária para representar o 
    // relacionamento entre Fornecedor e Produto

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento com forncecedor
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;


    // Relacionamento com produto
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    // Data que ccomeçou o vinculo
    private LocalDate dataInicio;

    // Data que terminou
    private LocalDate dataFim;
    
}
