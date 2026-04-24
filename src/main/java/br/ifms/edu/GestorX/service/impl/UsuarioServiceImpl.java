package br.ifms.edu.GestorX.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ifms.edu.GestorX.dto.UsuarioRequestDTO;
import br.ifms.edu.GestorX.dto.UsuarioResponseDTO;
import br.ifms.edu.GestorX.model.Usuario;
import br.ifms.edu.GestorX.repository.UsuarioRepository;
import br.ifms.edu.GestorX.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    // 🔹 Salvar usuário
    @Override
    public UsuarioResponseDTO salvar(UsuarioRequestDTO dto) {

        Usuario usuario = toEntity(dto);

        Usuario salvo = repository.save(usuario);

        return UsuarioResponseDTO.fromEntity(salvo);
    }

    // 🔹 Listar todos
    @Override
    public List<UsuarioResponseDTO> listar() {

        return repository.findAll()
                .stream()
                .map(UsuarioResponseDTO::fromEntity)
                .toList();
    }

    // 🔧 Conversão DTO → Entity
    private Usuario toEntity(UsuarioRequestDTO dto) {

        Usuario usuario = new Usuario();

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setTipoUsuario(dto.getTipoUsuario());

        usuario.setCpf(dto.getCpf());
        usuario.setCargo(dto.getCargo());
        usuario.setEstabelecimento(dto.getEstabelecimento());

        return usuario;
    }
}