package br.ifms.edu.GestorX.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.ifms.edu.GestorX.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{

}
