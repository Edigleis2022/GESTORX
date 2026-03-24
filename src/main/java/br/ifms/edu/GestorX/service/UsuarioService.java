package br.ifms.edu.GestorX.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.ifms.edu.GestorX.model.Usuario;

@Service
public interface UsuarioService {
    Usuario salvar(Usuario usuario);
    List<Usuario> listar();
}
