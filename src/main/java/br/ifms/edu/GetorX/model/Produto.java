package br.ifms.edu.GetorX.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipoProduto;
    private String marca;
    private Double valor;

    @ManyToMany(mappedBy = "produtos")
    private List<Fornecedor> fornecedores;

    public Long getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double getValor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
