package br.ifms.edu.GestaorX.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifms.edu.GestaorX.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public List<Usuario> findAll();

    public Usuario save(Usuario usuario);

}
