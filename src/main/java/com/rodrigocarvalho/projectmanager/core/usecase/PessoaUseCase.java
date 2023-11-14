package com.rodrigocarvalho.projectmanager.core.usecase;

import com.rodrigocarvalho.projectmanager.core.domain.Pessoa;

import java.math.BigInteger;
import java.util.List;

public interface PessoaUseCase {

    void insert(Pessoa pessoa);

    Pessoa findById(final BigInteger id);

    List<Pessoa> findAll();

    Pessoa update(Pessoa pessoa);

    void delete(final BigInteger id);

}
