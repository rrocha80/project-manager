package com.rodrigocarvalho.projectmanager.core.dataprovider;

import com.rodrigocarvalho.projectmanager.core.domain.Membro;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface MembroProvider {

    void insert(Membro membro);

    Optional<Membro> findById(final BigInteger projetoId, final BigInteger pessoaId);

    List<Membro> findAll();

    void delete(final BigInteger projetoId, final BigInteger pessoaId);
}
