package br.ifms.edu.GetorX.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ifms.edu.GetorX.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
