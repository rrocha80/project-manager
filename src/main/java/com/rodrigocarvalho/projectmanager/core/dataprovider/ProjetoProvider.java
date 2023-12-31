package com.rodrigocarvalho.projectmanager.core.dataprovider;

import com.rodrigocarvalho.projectmanager.core.domain.Projeto;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ProjetoProvider {
    void insert(Projeto projeto);

    Optional<Projeto> findById(final BigInteger id);

    List<Projeto> findAll();

    List<Projeto> findByAttributes(Projeto projeto);

    List<Projeto> findByNome(String projeto);

    Projeto update(Projeto projeto);

    void delete(final BigInteger id);
}
