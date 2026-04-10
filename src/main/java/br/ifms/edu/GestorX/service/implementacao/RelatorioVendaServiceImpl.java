package br.ifms.edu.GestorX.service.implementacao;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ifms.edu.GestorX.dto.RelatorioVendaRequestDTO;
import br.ifms.edu.GestorX.dto.RelatorioVendaResponseDTO;
import br.ifms.edu.GestorX.dto.VendaResponseDTO;
import br.ifms.edu.GestorX.model.Venda;
import br.ifms.edu.GestorX.repository.VendaRepository;
import br.ifms.edu.GestorX.service.RelatorioVendaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RelatorioVendaServiceImpl implements RelatorioVendaService {

    private final VendaRepository vendaRepository;

    @Override
    public RelatorioVendaResponseDTO gerarRelatorio(RelatorioVendaRequestDTO request) {

        // 📅 Busca vendas no período informado
        List<Venda> vendas = vendaRepository.findByDataVendaBetween(
                request.getDataInicio(),
                request.getDataFim()
        );

        // 💰 Soma total das vendas
        Double total = vendas.stream()
                .mapToDouble(Venda::getValorTotal)
                .sum();

        // 🔢 Quantidade de vendas
        Long quantidade = (long) vendas.size();

        // 🔄 Converter Venda → VendaResponseDTO
        List<VendaResponseDTO> vendasDTO = vendas.stream()
                .map(VendaResponseDTO::new) // depende do seu construtor
                .toList();

        // 📦 Monta resposta
        return new RelatorioVendaResponseDTO(
                request.getDataInicio(),
                request.getDataFim(),
                total,
                quantidade,
                vendasDTO
        );
    }
}
