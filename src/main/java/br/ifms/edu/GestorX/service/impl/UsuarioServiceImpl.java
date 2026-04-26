package br.ifms.edu.GestorX.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.ifms.edu.GestorX.dto.LoginRequestDTO;
import br.ifms.edu.GestorX.dto.UsuarioRequestDTO;
import br.ifms.edu.GestorX.dto.UsuarioResponseDTO;
import br.ifms.edu.GestorX.exception.RegraNegocioException;
import br.ifms.edu.GestorX.model.Usuario;
import br.ifms.edu.GestorX.repository.UsuarioRepository;
import br.ifms.edu.GestorX.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    private final PasswordEncoder passwordEncoder;

    // 🔹 Salvar usuário
    @Override
    public UsuarioResponseDTO salvar(UsuarioRequestDTO dto) {

        Usuario usuario = toEntity(dto);

        // 🔐 Criptografar senha ANTES de salvar
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));

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

     public UsuarioResponseDTO login(LoginRequestDTO dto) {

         Usuario usuario = repository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RegraNegocioException("Email ou senha inválidos"));

        // 🔐 compara senha digitada com criptografada
        if (!passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
             throw new RegraNegocioException("Email ou senha inválidos");
         }

         return UsuarioResponseDTO.fromEntity(usuario);
 }

}