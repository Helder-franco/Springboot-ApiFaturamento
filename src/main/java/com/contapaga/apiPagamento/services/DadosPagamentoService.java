package com.contapaga.apiPagamento.services;

import com.contapaga.apiPagamento.model.DadosPagamento;

import java.util.List;

public interface DadosPagamentoService {

    DadosPagamento save(DadosPagamento dadosPagamento);

    List<DadosPagamento> findAll();

    DadosPagamento findById(Long id);

    void delete(Long id);

    void update(DadosPagamento dadosPagamento, Long id);


    List<DadosPagamento> findByUltimosDias(Integer dias);
}
