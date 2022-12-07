package com.contapaga.apiPagamento.model;

import com.contapaga.apiPagamento.enums.TipoPagamentoEnum;
import com.contapaga.apiPagamento.enums.TipoServicoEnum;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class DadosPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoPagamentoEnum tipoPagamento;
    @Enumerated(EnumType.STRING)
    private TipoServicoEnum tipoServico;
    private Double valor;
    private Double taxa;
    @NotNull
    private Integer parcelas;
    @CreatedDate
    private LocalDateTime criado_em;
}