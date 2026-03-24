package br.ifms.edu.GestorX.model;

import java.util.List;

import br.ifms.edu.GestorX.enums.StatusFornecedor;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
@Table(name = "tb_supplier")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer telefone;
    private String email;
    private String endereco;

    //Cria uma Tabela Intermediária 
    @ManyToMany
    @JoinTable(
        name = "fornecedor_produto",
        joinColumns = @JoinColumn(name = "fornecedor_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;

    @Enumerated(EnumType.STRING)
    private StatusFornecedor status;
}