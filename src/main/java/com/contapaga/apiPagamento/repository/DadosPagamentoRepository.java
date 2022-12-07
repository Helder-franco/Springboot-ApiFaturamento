package com.contapaga.apiPagamento.repository;

import com.contapaga.apiPagamento.model.DadosPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DadosPagamentoRepository extends JpaRepository<DadosPagamento, Long> {
    @Query(value = "SELECT * from dados_pagamento where DATE_PART('day', CURRENT_TIMESTAMP - criado_em) < :dias", nativeQuery = true)
    public List<DadosPagamento> findByUltimosDias(Integer dias);
}
