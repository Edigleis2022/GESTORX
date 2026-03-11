package br.ifms.edu.GestaorX.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ifms.edu.GestaorX.model.Usuario;

@Service
public interface UsuarioService {
    Usuario salvar(Usuario usuario);
    List<Usuario> listar();
}
