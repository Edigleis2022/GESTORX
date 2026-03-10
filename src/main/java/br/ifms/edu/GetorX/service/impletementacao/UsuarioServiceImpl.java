package br.ifms.edu.GetorX.service.impletementacao;

import java.util.List;
import br.ifms.edu.GetorX.model.Usuario;
import br.ifms.edu.GetorX.repository.UsuarioRepository;
import br.ifms.edu.GetorX.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public List<Usuario> listar() {
        return repository.findAll();
    }

}
