package com.rodrigocarvalho.projectmanager.entrypoint.controller;

import com.rodrigocarvalho.projectmanager.core.domain.Membro;
import com.rodrigocarvalho.projectmanager.core.domain.Pessoa;
import com.rodrigocarvalho.projectmanager.core.domain.Projeto;
import com.rodrigocarvalho.projectmanager.core.usecase.MembroUseCase;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.mapper.MembroMapper;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.request.MembroRequest;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.response.MembroResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/v1/membro")
public class MembroController {

    @Autowired
    private MembroUseCase membroUseCase;

    @Autowired
    private MembroMapper membroMapper;

    @PostMapping("/insert")
    public ResponseEntity<Void> insert(@Valid @RequestBody MembroRequest membroRequest) {
        //var membro = membroMapper.toMembro(membroRequest);
        Membro membro = new Membro();
        membro.setProjeto(new Projeto(membroRequest.getProjeto().getId()));
        membro.setPessoa(new Pessoa(membroRequest.getPessoa().getId()));
        membroUseCase.insert(membro);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/{ProjetoId}/{PessoaId}")
    public ResponseEntity<MembroResponse> findById(@PathVariable final BigInteger ProjetoId,
                                                   @PathVariable final BigInteger PessoaId) {
        var membro = membroUseCase.findById(ProjetoId, PessoaId);
        var membroResponse = membroMapper.toMembroResponse(membro);

        return ResponseEntity.ok().body(membroResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MembroResponse>> findAll() {
        var membros = membroUseCase.findAll();
        var pessoaResponse = membroMapper.toMembroResponseList(membros);

        return ResponseEntity.ok().body(pessoaResponse);
    }

    @DeleteMapping("/delete/{ProjetoId}/{PessoaId}")
    public ResponseEntity<Void> delete(@PathVariable final BigInteger ProjetoId,
                                       @PathVariable final BigInteger PessoaId) {
        membroUseCase.delete(ProjetoId, PessoaId);

        return ResponseEntity.ok().build();
    }
}
