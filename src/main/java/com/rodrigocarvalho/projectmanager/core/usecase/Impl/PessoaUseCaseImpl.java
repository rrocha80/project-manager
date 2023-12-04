package com.rodrigocarvalho.projectmanager.core.usecase.Impl;

import com.rodrigocarvalho.projectmanager.config.exception.BusinessException;
import com.rodrigocarvalho.projectmanager.core.dataprovider.PessoaProvider;
import com.rodrigocarvalho.projectmanager.core.domain.Pessoa;
import com.rodrigocarvalho.projectmanager.config.exception.RecNotFountException;
import com.rodrigocarvalho.projectmanager.core.usecase.PessoaUseCase;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

public class PessoaUseCaseImpl implements PessoaUseCase {
    private final PessoaProvider provider;

    public PessoaUseCaseImpl(PessoaProvider insertPessoa) {
        this.provider = insertPessoa;
    }

    @Override
    public Pessoa insert(Pessoa pessoa) {
        var result = findByCpf(pessoa.getCpf());

        if (Objects.nonNull(result)) {
            throw new BusinessException("Pessoa já cadastrada com este CPF");
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
        provider.delete(id);
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
