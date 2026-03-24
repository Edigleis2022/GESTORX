package br.ifms.edu.GestorX.service.implementacao;

import java.util.List;
import org.springframework.stereotype.Service;
import br.ifms.edu.GestorX.model.MovimentoEstoque;
import br.ifms.edu.GestorX.repository.MovimentoEtoqueRepository;
import br.ifms.edu.GestorX.service.MovimentoEstoqueService;

@Service
public class MovimentoEstoqueImpl implements MovimentoEstoqueService {

    private final MovimentoEtoqueRepository repository;

    public MovimentoEstoqueImpl(MovimentoEtoqueRepository repository) {
        this.repository = repository;
    }

        public MovimentoEstoque salvar(MovimentoEstoque movimentoEstoque) {
            return repository.save(movimentoEstoque);
        }

        public List<MovimentoEstoque> listar(){
            return repository.findAll();
        }

}
