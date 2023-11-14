package com.rodrigocarvalho.projectmanager.config;

import com.rodrigocarvalho.projectmanager.core.dataprovider.ProjetoProvider;
import com.rodrigocarvalho.projectmanager.core.usecase.Impl.ProjetoUseCaseImpl;
import org.springframework.context.annotation.Bean;

public class ProjetoConfig {
    @Bean
    public ProjetoUseCaseImpl projetoUseCase(ProjetoProvider projetoProvider){
        return new ProjetoUseCaseImpl(projetoProvider);
    }
}
