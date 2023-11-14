package com.rodrigocarvalho.projectmanager.config;

import com.rodrigocarvalho.projectmanager.core.dataprovider.PessoaProvider;
import com.rodrigocarvalho.projectmanager.core.usecase.Impl.PessoaUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PessoaConfig {
    @Bean
    public PessoaUseCaseImpl pessoaUseCase(PessoaProvider pessoaProvider){
        return new PessoaUseCaseImpl(pessoaProvider);
    }

}
