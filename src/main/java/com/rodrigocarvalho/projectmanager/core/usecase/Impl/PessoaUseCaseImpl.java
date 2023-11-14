package com.rodrigocarvalho.projectmanager.core.usecase.Impl;

import com.rodrigocarvalho.projectmanager.core.dataprovider.PessoaProvider;
import com.rodrigocarvalho.projectmanager.core.domain.Pessoa;
import com.rodrigocarvalho.projectmanager.core.usecase.PessoaUseCase;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

public class PessoaUseCaseImpl implements PessoaUseCase {
    private final PessoaProvider provider;

    public PessoaUseCaseImpl(PessoaProvider provider) {
        this.provider = provider;
    }

    @Override
    public void insert(Pessoa pessoa) {
        provider.insert(pessoa);
    }

    @Override
    public Pessoa findById(BigInteger id) {
        return provider.findById(id).orElseThrow(() -> new RuntimeException("Não Encontrado"));
    }

    @Override
    public List<Pessoa> findAll() {
        return provider.findAll();
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        provider.findById(pessoa.getId());
        return provider.update(pessoa);
    }

    @Override
    public void delete(BigInteger id) {
        provider.findById(id);
        provider.delete(id);
    }
}
