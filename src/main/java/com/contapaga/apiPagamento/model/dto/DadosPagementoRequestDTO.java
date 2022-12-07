package com.contapaga.apiPagamento.model.dto;

import com.contapaga.apiPagamento.enums.TipoPagamentoEnum;
import com.contapaga.apiPagamento.enums.TipoServicoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor @NoArgsConstructor
public class DadosPagementoRequestDTO {
    @NotNull
    private TipoPagamentoEnum tipoPagamento;
    @NotNull
    private TipoServicoEnum tipoServico;
    @NotNull
    private Double valor;
    @NotNull
    private Double taxa;
    @NotNull
    private Integer parcelas;
}
