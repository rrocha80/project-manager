package com.rodrigocarvalho.projectmanager.core.usecase.Impl;

import com.rodrigocarvalho.projectmanager.core.dataprovider.ProjetoProvider;
import com.rodrigocarvalho.projectmanager.core.domain.Enum.StatusEnum;
import com.rodrigocarvalho.projectmanager.core.domain.Projeto;
import com.rodrigocarvalho.projectmanager.core.usecase.ProjetoUseCase;

import java.math.BigInteger;
import java.util.List;

public class ProjetoUseCaseImpl implements ProjetoUseCase {

    private final ProjetoProvider provider;

    public ProjetoUseCaseImpl(ProjetoProvider provider) {
        this.provider = provider;
    }


    @Override
    public void insert(Projeto projeto) {
        provider.insert(projeto);
    }

    @Override
    public Projeto findById(BigInteger id) {
        return provider.findById(id).orElseThrow(() -> new RuntimeException("Não Encontrado"));
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
            case INICIADO, EM_ANDAMENTO, ENCERRADO:
                new RuntimeException("Não é permitido remover o projeto.");
                break;
            default: provider.delete(id);
        }
    }
}
