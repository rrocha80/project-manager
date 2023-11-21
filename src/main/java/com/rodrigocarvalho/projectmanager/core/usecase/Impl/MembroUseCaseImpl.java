package com.rodrigocarvalho.projectmanager.core.usecase.Impl;

import com.rodrigocarvalho.projectmanager.core.dataprovider.MembroProvider;
import com.rodrigocarvalho.projectmanager.core.domain.Membro;
import com.rodrigocarvalho.projectmanager.core.exception.RecNotFountException;
import com.rodrigocarvalho.projectmanager.core.usecase.MembroUseCase;

import java.math.BigInteger;
import java.util.List;

public class MembroUseCaseImpl implements MembroUseCase {

    private final MembroProvider provider;

    public MembroUseCaseImpl(MembroProvider provider) {
        this.provider = provider;
    }

    @Override
    public void insert(Membro membro) {
        provider.insert(membro);
    }

    @Override
    public Membro findById(BigInteger projetoId, BigInteger pessoaId) {
        return provider.findById(projetoId, pessoaId).orElseThrow(() -> new RecNotFountException(pessoaId));
    }

    @Override
    public List<Membro> findAll() {
        return provider.findAll();
    }

    @Override
    public void delete(BigInteger projetoId, BigInteger pessoaId) {
        findById(projetoId, pessoaId);
        provider.delete(projetoId, pessoaId);

    }
}
