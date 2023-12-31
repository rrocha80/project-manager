package com.rodrigocarvalho.projectmanager.core.usecase.Impl;

import com.rodrigocarvalho.projectmanager.core.dataprovider.ProjetoProvider;
import com.rodrigocarvalho.projectmanager.core.domain.Enum.StatusEnum;
import com.rodrigocarvalho.projectmanager.core.domain.Projeto;
import com.rodrigocarvalho.projectmanager.config.exception.RecNotFountException;
import com.rodrigocarvalho.projectmanager.core.usecase.ProjetoUseCase;

import java.math.BigInteger;
import java.util.List;

public class ProjetoUseCaseImpl implements ProjetoUseCase {

    private final ProjetoProvider provider;

    private final String IMPOSSIVEL_REMOVER_PROJETO = "Não é permitido remover projetos nos seguintes status: "
        + "(Iniciado, Em andamento ou Encerrado).";

    public ProjetoUseCaseImpl(ProjetoProvider provider) {
        this.provider = provider;
    }


    @Override
    public void insert(Projeto projeto) {
        provider.insert(projeto);
    }

    @Override
    public Projeto findById(BigInteger id) {
        return provider.findById(id).orElseThrow(() -> new RecNotFountException(id));
    }

    @Override
    public List<Projeto> findAll() {
        return provider.findAll();
    }

    @Override
    public Projeto update(Projeto projeto) {
        findById(projeto.getId());
        return provider.update(projeto);
    }

    @Override
    public void delete(BigInteger id) {
        Projeto projeto = findById(id);
        StatusEnum status = projeto.getStatus();

        switch (status){
            case INICIADO, EM_ANDAMENTO, ENCERRADO: {
                throw new RuntimeException(IMPOSSIVEL_REMOVER_PROJETO);
            }
            default: provider.delete(id);
        }
    }

    @Override
    public List<Projeto> findByAttributes(Projeto projeto) {
        return provider.findByAttributes(projeto);
    }

    @Override
    public List<Projeto> findByNome(String nome) {
        return provider.findByNome(nome);
    }
}
