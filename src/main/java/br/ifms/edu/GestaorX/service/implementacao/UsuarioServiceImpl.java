package br.ifms.edu.GestaorX.service.implementacao;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ifms.edu.GestaorX.model.Usuario;
import br.ifms.edu.GestaorX.repository.UsuarioRepository;
import br.ifms.edu.GestaorX.service.UsuarioService;

@Service
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
