package com.contapaga.apiPagamento.services.impl;

import com.contapaga.apiPagamento.model.DadosPagamento;
import com.contapaga.apiPagamento.repository.DadosPagamentoRepository;
import com.contapaga.apiPagamento.services.DadosPagamentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosPagamentoServiceImpl implements DadosPagamentoService {

    @Autowired
    DadosPagamentoRepository repository;

    @Override
    public DadosPagamento save(DadosPagamento dadosPagamento) {
        return repository.save(dadosPagamento);
    }

    @Override
    public List<DadosPagamento> findAll() {
        return repository.findAll();
    }

    @Override
    public List<DadosPagamento> findByUltimosDias(Integer dias) {
        return repository.findByUltimosDias(dias);
    }
    @Override
    public DadosPagamento findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(DadosPagamento dadosPagamento, Long id) {
        DadosPagamento dadosPagamentoOld = repository.findById(id).get();
        BeanUtils.copyProperties(dadosPagamento, dadosPagamentoOld, "id");
    }
}
