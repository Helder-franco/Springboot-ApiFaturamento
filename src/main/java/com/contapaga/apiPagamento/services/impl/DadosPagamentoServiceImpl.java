package com.contapaga.apiPagamento.services.impl;

import com.contapaga.apiPagamento.model.DadosPagamento;
import com.contapaga.apiPagamento.repository.DadosPagamentoRepository;
import com.contapaga.apiPagamento.services.DadosPagamentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DadosPagamentoServiceImpl implements DadosPagamentoService {

    private final DadosPagamentoRepository repository;

    public DadosPagamentoServiceImpl(DadosPagamentoRepository repository) {
        this.repository = repository;
    }

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
        Optional<DadosPagamento> dadosPagamentoOpt = repository.findById(id);
        return dadosPagamentoOpt.orElse(null);

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(DadosPagamento dadosPagamento, Long id) {
        DadosPagamento dadosPagamentoOld = this.findById(id);
        if(dadosPagamento != null) {
            BeanUtils.copyProperties(dadosPagamento, dadosPagamentoOld, "id");
            this.save(dadosPagamentoOld);
        } else {
            throw new RuntimeException("Não foi localizado o registro.");
        }

    }
}
