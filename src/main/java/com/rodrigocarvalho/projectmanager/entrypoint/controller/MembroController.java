package com.rodrigocarvalho.projectmanager.entrypoint.controller;

import com.rodrigocarvalho.projectmanager.core.dataprovider.PessoaProvider;
import com.rodrigocarvalho.projectmanager.core.dataprovider.ProjetoProvider;
import com.rodrigocarvalho.projectmanager.core.domain.Membro;
import com.rodrigocarvalho.projectmanager.core.domain.Pessoa;
import com.rodrigocarvalho.projectmanager.core.domain.Projeto;
import com.rodrigocarvalho.projectmanager.core.usecase.MembroUseCase;
import com.rodrigocarvalho.projectmanager.core.usecase.PessoaUseCase;
import com.rodrigocarvalho.projectmanager.core.usecase.ProjetoUseCase;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.PessoaRepository;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.ProjetoRepository;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.exception.ResourceNotFoundException;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.mapper.MembroMapper;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.request.MembroRequest;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.response.MembroResponse;
import io.swagger.v3.oas.annotations.Operation;
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

    @Autowired
    private PessoaUseCase pessoaUseCase;

    @Autowired
    private ProjetoUseCase projetoUseCase;

    @Operation(summary = "request body => { \"projeto\": { \"id\": {id do projeto}, \"pessoa\": { \"nome\": \"{nome exato da pessoa}\" } }")
    @PostMapping("/insert")
    public ResponseEntity<Void> insert(@Valid @RequestBody MembroRequest membroRequest) {
        try{
            Membro membro = new Membro();
            var pessoas = pessoaUseCase.findByAttributes(membroRequest.getPessoa());
            var projeto = projetoUseCase.findById(membroRequest.getProjeto().getId());
            membro.setProjeto(projeto);
            membro.setPessoa(pessoas.get(0));
            membroUseCase.insert(membro);
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }

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
