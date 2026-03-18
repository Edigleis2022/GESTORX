package br.ifms.edu.GestaorX.model;

import java.util.List;

import br.ifms.edu.GestaorX.enums.CategoriaProduto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_product")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double preco;
    private Integer quantidade;

    @ManyToMany(mappedBy = "produtos")
    private List<Fornecedor> fornecedores;

    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoria;

}
