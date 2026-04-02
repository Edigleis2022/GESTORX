package br.ifms.edu.GestorX.model;

import java.util.List;
import br.ifms.edu.GestorX.enums.CategoriaProduto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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

    @OneToMany(mappedBy = "produto")
    private List<FornecedorProduto> fornecedoresProdutos;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoria;
}
