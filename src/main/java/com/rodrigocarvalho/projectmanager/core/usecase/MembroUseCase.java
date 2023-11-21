package com.rodrigocarvalho.projectmanager.core.usecase;

import com.rodrigocarvalho.projectmanager.core.domain.Membro;

import java.math.BigInteger;
import java.util.List;

public interface MembroUseCase {

    void insert(Membro membro);

    Membro findById(final BigInteger projetoId, final BigInteger pessoaId);

    List<Membro> findAll();

    void delete(final BigInteger projetoId, final BigInteger pessoaId);
}
