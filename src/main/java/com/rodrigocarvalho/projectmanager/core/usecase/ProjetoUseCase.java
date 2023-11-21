package com.rodrigocarvalho.projectmanager.core.usecase;

import com.rodrigocarvalho.projectmanager.core.domain.Projeto;

import java.math.BigInteger;
import java.util.List;

public interface ProjetoUseCase {
    void insert(Projeto projeto);

    Projeto findById(final BigInteger id);

    List<Projeto> findAll();

    Projeto update(Projeto projeto);

    void delete(final BigInteger id);

    List<Projeto> findByAttributes(Projeto projeto);

    List<Projeto> findByNome(String nome);
}
