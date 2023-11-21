package com.rodrigocarvalho.projectmanager.entrypoint.controller;

import com.rodrigocarvalho.projectmanager.core.domain.Pessoa;
import com.rodrigocarvalho.projectmanager.core.usecase.PessoaUseCase;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.mapper.PessoaMapper;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.request.PessoaRequest;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.response.PessoaResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/pessoa")
public class PessoaController {

    @Autowired
    private PessoaUseCase pessoaUseCase;

    @Autowired
    private PessoaMapper pessoaMapper;

    @PostMapping("/insert")
    public ResponseEntity<Void> insert(@Valid @RequestBody PessoaRequest pessoaRequest) {
        var pessoa = pessoaMapper.toPessoa(pessoaRequest);
        pessoaUseCase.insert(pessoa);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<PessoaResponse> findById(@PathVariable final BigInteger id) {
        var pessoa = pessoaUseCase.findById(id);
        var pessoaResponse = pessoaMapper.toPessoaResponse(pessoa);

        return ResponseEntity.ok().body(pessoaResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PessoaResponse>> findAll() {
        var pessoas = pessoaUseCase.findAll();
        var pessoaResponse = pessoaMapper.toPessoaResponseList(pessoas);

        return ResponseEntity.ok().body(pessoaResponse);
    }

    @GetMapping("/byattributes")
    public ResponseEntity<List<PessoaResponse>> findbyAttributes(@RequestBody Pessoa pessoa) {
        var pessoas = pessoaUseCase.findByAttributes(pessoa);
        var pessoaResponse = pessoaMapper.toPessoaResponseList(pessoas);

        return ResponseEntity.ok().body(pessoaResponse);
    }

    @GetMapping("/searchname/{nome}")
    public ResponseEntity<List<PessoaResponse>> findById(@PathVariable final String nome) {
        var pessoas = pessoaUseCase.findByNome(nome);
        var pessoaResponse = pessoaMapper.toPessoaResponseList(pessoas);

        return ResponseEntity.ok().body(pessoaResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<PessoaResponse> update(@Valid @RequestBody PessoaRequest pessoaRequest) {
        var pessoa = pessoaMapper.toPessoa(pessoaRequest);
        var pessoaResponse = pessoaMapper.toPessoaResponse(pessoa);

        if (Objects.isNull(pessoa)) {
            return ResponseEntity.notFound().build();
        }

        pessoaUseCase.update(pessoa);

        return ResponseEntity.ok(pessoaResponse);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable BigInteger id) {
        pessoaUseCase.delete(id);

        return ResponseEntity.ok().build();
    }
}
