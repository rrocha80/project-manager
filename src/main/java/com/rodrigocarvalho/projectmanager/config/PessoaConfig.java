package com.rodrigocarvalho.projectmanager.config;

import com.rodrigocarvalho.projectmanager.core.dataprovider.PessoaProvider;
import com.rodrigocarvalho.projectmanager.core.domain.Pessoa;
import com.rodrigocarvalho.projectmanager.core.usecase.Impl.PessoaUseCaseImpl;
import com.rodrigocarvalho.projectmanager.core.usecase.PessoaUseCase;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.mapper.PessoaMapper;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.request.PessoaRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PessoaConfig {
    @Bean
    public PessoaUseCaseImpl pessoaUseCase(PessoaProvider insertPessoa){
        return new PessoaUseCaseImpl(insertPessoa);
    }

}
