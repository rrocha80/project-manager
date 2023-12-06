package com.rodrigocarvalho.projectmanager.core.usecase.Impl;

import com.rodrigocarvalho.projectmanager.config.exception.BusinessException;
import com.rodrigocarvalho.projectmanager.core.dataprovider.PessoaProvider;
import com.rodrigocarvalho.projectmanager.core.domain.Pessoa;
import com.rodrigocarvalho.projectmanager.config.exception.RecNotFountException;
import com.rodrigocarvalho.projectmanager.core.usecase.PessoaUseCase;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.exception.ResourceNotFoundException;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

public class PessoaUseCaseImpl implements PessoaUseCase {
    private final PessoaProvider provider;
    private final String IMPOSSIVEL_REMOVER_PESSOA =  "Não é possível remover a pessoa, pois está vinculada a um ou "
        + "mais projetos.";
    private final String IMPOSSIVEL_INSERIR_PESSOA =  "Pessoa já cadastrada com este CPF";

    public PessoaUseCaseImpl(PessoaProvider insertPessoa) {
        this.provider = insertPessoa;
    }

    @Override
    public Pessoa insert(Pessoa pessoa) {
        var result = findByCpf(pessoa.getCpf());

        if (Objects.nonNull(result)) {
            throw new BusinessException(IMPOSSIVEL_INSERIR_PESSOA);
        }
        return provider.insert(pessoa);
    }

    @Override
    public Pessoa findById(BigInteger id) {
        return provider.findById(id).orElseThrow(() -> new RecNotFountException(id));
    }

    @Override
    public List<Pessoa> findAll() {
        return provider.findAll();
    }

    @Override
    public List<Pessoa> findByAttributes(Pessoa pessoa) {
        return provider.findByAttributes(pessoa);
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        findById(pessoa.getId());
        return provider.update(pessoa);
    }

    @Override
    public void delete(BigInteger id) {
        findById(id);
        try {
            provider.delete(id);
        } catch (RuntimeException e) {
            throw new RuntimeException(IMPOSSIVEL_REMOVER_PESSOA);
        }
    }

    @Override
    public List<Pessoa> findByNome(String nome) {
        return provider.findByNome(nome);
    }

    @Override
    public Pessoa findByCpf(String cpf) {
        return provider.findByCpf(cpf);
    }

}
