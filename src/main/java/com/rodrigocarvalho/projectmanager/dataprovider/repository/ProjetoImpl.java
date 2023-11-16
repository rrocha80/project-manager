package com.rodrigocarvalho.projectmanager.dataprovider.repository;

import com.rodrigocarvalho.projectmanager.core.dataprovider.ProjetoProvider;
import com.rodrigocarvalho.projectmanager.core.domain.Projeto;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.mapper.ProjetoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProjetoImpl implements ProjetoProvider {

    @Autowired
    ProjetoRepository repository;

    @Autowired
    ProjetoEntityMapper projetoEntityMapper;

    @Override
    public void insert(Projeto projeto) {
        var projetoEntity = projetoEntityMapper.toProjetoEntity(projeto);
        repository.save(projetoEntity);
    }

    @Override
    public Optional<Projeto> findById(BigInteger id) {
        var projeto = repository.findById(id);
        return projeto.map(entity -> projetoEntityMapper.toProjeto(entity));
    }

    @Override
    public List<Projeto> findAll() {
        var projetos = repository.findAll();
        List<Projeto> list = new ArrayList<>();
        projetos.forEach(projetoEntity -> list.add(projetoEntityMapper.toProjeto(projetoEntity)));
        return list;
    }

    @Override
    public Projeto update(Projeto projeto) {
        var projetoEntity = projetoEntityMapper.toProjetoEntity(projeto);
        repository.save(projetoEntity);
        return projeto;
    }

    @Override
    public void delete(BigInteger id) {
        repository.deleteById(id);
    }
}
