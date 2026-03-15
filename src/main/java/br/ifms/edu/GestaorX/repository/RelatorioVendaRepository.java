package br.ifms.edu.GestaorX.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifms.edu.GestaorX.model.RelatorioVenda;

@Repository
public interface RelatorioVendaRepository extends JpaRepository<RelatorioVenda, Long>{

}
