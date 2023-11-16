package com.rodrigocarvalho.projectmanager.config;

import com.rodrigocarvalho.projectmanager.core.usecase.Impl.ProjetoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjetoConfig {
    @Bean
    public ProjetoUseCaseImpl projetoUseCase(com.rodrigocarvalho.projectmanager.core.dataprovider.ProjetoProvider projetoProvider){
        return new ProjetoUseCaseImpl(projetoProvider);
    }
}
