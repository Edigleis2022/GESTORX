package br.ifms.edu.GestorX.dto;


public class UsuarioDetalhadoDTO {
    private Long id;
    private String nome;
    private String email;
    private String tipoUsuario;
    private String cpf; // 🔐 aqui sim
    private String cargo;
    private String estabelecimento;
}