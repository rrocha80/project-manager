package com.rodrigocarvalho.projectmanager.core.usecase;

import com.rodrigocarvalho.projectmanager.core.domain.Pessoa;

import java.math.BigInteger;
import java.util.List;

public interface PessoaUseCase {

    Pessoa insert(Pessoa pessoa);

    Pessoa findById(final BigInteger id);

    List<Pessoa> findAll();

    List<Pessoa> findByAttributes(Pessoa pessoa);

    Pessoa update(Pessoa pessoa);

    void delete(final BigInteger id);

    List<Pessoa> findByNome(String nome);

    Pessoa findByCpf(String cpf);
}
