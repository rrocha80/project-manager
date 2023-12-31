package com.rodrigocarvalho.projectmanager.core.dataprovider;

import com.rodrigocarvalho.projectmanager.core.domain.Pessoa;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface PessoaProvider {
    Pessoa insert(Pessoa pessoa);

    Optional<Pessoa> findById(final BigInteger id);

    List<Pessoa> findAll();

    List<Pessoa> findByAttributes(Pessoa pessoa);

    List<Pessoa> findByNome(String pessoa);

    Pessoa update(Pessoa pessoa);

    void delete(final BigInteger id);

    Pessoa findByCpf(String cpf);
}
