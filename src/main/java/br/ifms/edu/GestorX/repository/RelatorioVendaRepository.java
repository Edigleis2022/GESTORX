package br.ifms.edu.GestorX.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifms.edu.GestorX.model.RelatorioVenda;

@Repository
public interface RelatorioVendaRepository extends JpaRepository<RelatorioVenda, Long>{

}
