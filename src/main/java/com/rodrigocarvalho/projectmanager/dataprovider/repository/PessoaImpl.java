package com.rodrigocarvalho.projectmanager.dataprovider.repository;

import com.rodrigocarvalho.projectmanager.core.dataprovider.PessoaProvider;
import com.rodrigocarvalho.projectmanager.core.domain.Pessoa;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.mapper.PessoaEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PessoaImpl implements PessoaProvider {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private PessoaEntityMapper pessoaEntityMapper;

    @Override
    public void insert(Pessoa pessoa) {
        var pessoaEntity = pessoaEntityMapper.toPessoaEntity(pessoa);
        repository.save(pessoaEntity);
    }

    @Override
    public Optional<Pessoa> findById(BigInteger id) {
        var pessoa = repository.findById(id);
        return pessoa.map(entity -> pessoaEntityMapper.toPessoa(entity));
    }

    @Override
    public List<Pessoa> findAll() {
        var pessoas = repository.findAll();
        List<Pessoa> list = new ArrayList<>();
        pessoas.forEach(pessoaEntity -> list.add(pessoaEntityMapper.toPessoa(pessoaEntity)));
        return list;
    }

    @Override
    public List<Pessoa> findByAttributes(Pessoa pessoa) {
        var pessoaEntity = pessoaEntityMapper.toPessoaEntity(pessoa);
        var pessoas = repository.findAll(Example.of(pessoaEntity));
        List<Pessoa> list = new ArrayList<>();
        pessoas.forEach(p -> list.add(pessoaEntityMapper.toPessoa(p)));
        return list;
    }

    @Override
    public List<Pessoa> findByNome(String pessoa) {
        var pessoas = repository.findByNomeContaining(pessoa);
        List<Pessoa> list = new ArrayList<>();
        pessoas.forEach(p -> list.add(pessoaEntityMapper.toPessoa(p)));
        return list;
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        var pessoaEntity = pessoaEntityMapper.toPessoaEntity(pessoa);
        repository.save(pessoaEntity);
        return pessoa;
    }

    @Override
    public void delete(BigInteger id) {
        repository.deleteById(id);
    }
}
