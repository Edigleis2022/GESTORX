package br.ifms.edu.GestaorX.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    private String nome;
    private String senha;
}
