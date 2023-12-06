package com.rodrigocarvalho.projectmanager.entrypoint.controller;

import com.rodrigocarvalho.projectmanager.config.exception.BusinessException;
import com.rodrigocarvalho.projectmanager.config.exception.RecNotFountException;
import com.rodrigocarvalho.projectmanager.core.domain.Projeto;
import com.rodrigocarvalho.projectmanager.core.usecase.ProjetoUseCase;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.exception.GlobalExceptionHandler;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.exception.ResourceNotFoundException;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.mapper.ProjetoMapper;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.request.ProjetoRequest;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.response.ProjetoResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/projeto")
public class ProjetoController {

    @Autowired
    ProjetoUseCase projetoUseCase;

    @Autowired
    ProjetoMapper projetoMapper;

    @PostMapping("/insert")
    public ResponseEntity<Void> insert(@Valid @RequestBody ProjetoRequest projetoRequest) {
        var projeto = projetoMapper.toProjeto(projetoRequest);
        projetoUseCase.insert(projeto);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<ProjetoResponse> findById(@PathVariable final BigInteger id) {
        try {
            var projeto = projetoUseCase.findById(id);
            var projetoResponse = projetoMapper.toProjetoResponse(projeto);

            return ResponseEntity.ok().body(projetoResponse);
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjetoResponse>> findAll() {
        var projetos = projetoUseCase.findAll();
        var projetoResponse = projetoMapper.toProjetoResponseList(projetos);

        return ResponseEntity.ok().body(projetoResponse);
    }

    @PostMapping("/byattributes")
    public ResponseEntity<List<ProjetoResponse>> findbyAttributes(@RequestBody Projeto projeto) {
        var projetos = projetoUseCase.findByAttributes(projeto);
        var projetoResponse = projetoMapper.toProjetoResponseList(projetos);

        return ResponseEntity.ok(projetoResponse);
    }

    @GetMapping("/searchname/{nome}")
    public ResponseEntity<List<ProjetoResponse>> findById(@PathVariable final String nome) {
        var projetos = projetoUseCase.findByNome(nome);
        var projetoResponse = projetoMapper.toProjetoResponseList(projetos);

        return ResponseEntity.ok(projetoResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<ProjetoResponse> update(@Valid @RequestBody ProjetoRequest projetoRequest) {
        var projeto = projetoMapper.toProjeto(projetoRequest);
        var projetoResponse = projetoMapper.toProjetoResponse(projeto);

        if (Objects.isNull(projeto)) {
            return ResponseEntity.notFound().build();
        }

        projetoUseCase.update(projeto);

        return ResponseEntity.ok(projetoResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable BigInteger id) {
        try {
            projetoUseCase.delete(id);
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }


        return ResponseEntity.ok().build();
    }
}
