package com.rodrigocarvalho.projectmanager.dataprovider.repository;

import com.rodrigocarvalho.projectmanager.core.dataprovider.MembroProvider;
import com.rodrigocarvalho.projectmanager.core.domain.Membro;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.MembroEntity;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.mapper.MembroEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MembroImpl implements MembroProvider {

    @Autowired
    private MembroRepository repository;

    @Autowired
    ProjetoRepository projetoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private MembroEntityMapper membroEntityMapper;

    @Override
    public void insert(Membro membro) {
        var projeto = projetoRepository.findById(membro.getProjeto().getId());
        var pessoa = pessoaRepository.findById(membro.getPessoa().getId());
        repository.save(MembroEntity.builder().projeto(projeto.get()).pessoa(pessoa.get()).build());
    }

    @Override
    public Optional<Membro> findById(BigInteger projetoId, BigInteger pessoaId) {
        var projeto = projetoRepository.findById(projetoId);
        var pessoa = pessoaRepository.findById(pessoaId);
        var membroEntity = repository.findByProjetoAndPessoa(projeto.get(), pessoa.get());
        return membroEntity.map(entity -> membroEntityMapper.toMembro(entity));
    }

    @Override
    public List<Membro> findAll() {
        var membros = repository.findAll();
        List<Membro> list = new ArrayList<>();
        membros.forEach(membroEntity -> list.add(membroEntityMapper.toMembro(membroEntity)));
        return list;
    }

    @Override
    public void delete(BigInteger projetoId, BigInteger pessoaId) {
        var projeto = projetoRepository.findById(projetoId);
        var pessoa = pessoaRepository.findById(pessoaId);
        var membro = findById(projeto.get().getId(), pessoa.get().getId());
        var membroEntity = membroEntityMapper.toMembroEntity(membro.get());

        repository.delete(membroEntity);
    }
}
