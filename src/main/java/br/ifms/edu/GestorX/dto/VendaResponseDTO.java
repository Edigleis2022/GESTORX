package br.ifms.edu.GestorX.dto;

import java.time.LocalDate;

import br.ifms.edu.GestorX.enums.TipoPagamento;
import lombok.Data;

@Data
public class VendaResponseDTO {

    private Long id;

    // 📦 Quantidade vendida
    private Integer quantidadeItens;

    // 💰 Valor total calculado
    private Double valorTotal;

    // 📅 Data da venda
    private LocalDate dataVenda;

    // 💳 Tipo de pagamento
    private TipoPagamento tipoPagamento;

    // 🔗 Dados extras (opcional, mas profissional)
    private Long produtoId;
    private String nomeProduto;
}