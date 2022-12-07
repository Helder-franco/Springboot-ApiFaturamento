package com.contapaga.apiPagamento.controller;

import com.contapaga.apiPagamento.model.DadosPagamento;
import com.contapaga.apiPagamento.model.dto.DadosPagementoRequestDTO;
import com.contapaga.apiPagamento.services.DadosPagamentoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class DadosPagamentoController {

    private final DadosPagamentoService service;
    private final ModelMapper modelMapper;

    public DadosPagamentoController(DadosPagamentoService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<DadosPagamento>> findAll() {
        List<DadosPagamento> List = service.findAll();
        return ResponseEntity.ok().body(List);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DadosPagamento> findById(@PathVariable Long id) {
        DadosPagamento obj = service.findById(id);
        if(obj != null)
            return ResponseEntity.ok().body(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/dias/{dias}")
    public ResponseEntity<List<DadosPagamento>> findByUltimosDias(@PathVariable Integer dias) {
        List<DadosPagamento> obj = service.findByUltimosDias(dias);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<DadosPagamento> insert(@Valid @RequestBody DadosPagementoRequestDTO dto){
        DadosPagamento entity = this.modelMapper.map(dto, DadosPagamento.class);
        DadosPagamento entitySave = service.save(entity);
        return ResponseEntity.ok().body(entitySave);
    }


}
