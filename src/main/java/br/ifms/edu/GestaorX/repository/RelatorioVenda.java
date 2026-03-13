package br.ifms.edu.GestaorX.repository;

import org.springframework.data.jpa.repositoryJpaRepository;
import br.ifms.edu.GestaoX.model.RelatorioVenda;

@Repository
public interface RelatorioVenda extends JpaRepository<RelatorioVenda, Long>{

}
