package br.ifms.edu.GestaorX.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioVenda extends JpaRepository<RelatorioVenda, Long>{

}
