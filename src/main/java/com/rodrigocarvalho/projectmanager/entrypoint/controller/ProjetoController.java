package com.rodrigocarvalho.projectmanager.entrypoint.controller;

import com.rodrigocarvalho.projectmanager.core.usecase.ProjetoUseCase;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.mapper.ProjetoMapper;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.request.ProjetoRequest;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.response.ProjetoResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        var projeto = projetoUseCase.findById(id);
        var projetoResponse = projetoMapper.toProjetoResponse(projeto);
        return ResponseEntity.ok().body(projetoResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjetoResponse>> findAll() {
        var projetos = projetoUseCase.findAll();
        var projetoResponse = projetoMapper.toProjetoResponseList(projetos);
        return ResponseEntity.ok().body(projetoResponse);
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

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable BigInteger id) {
        projetoUseCase.delete(id);
        return ResponseEntity.ok().build();
    }
}
