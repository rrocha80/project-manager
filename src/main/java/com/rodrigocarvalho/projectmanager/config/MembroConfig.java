package com.rodrigocarvalho.projectmanager.config;

import com.rodrigocarvalho.projectmanager.core.dataprovider.MembroProvider;
import com.rodrigocarvalho.projectmanager.core.usecase.Impl.MembroUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MembroConfig {

    @Bean
    public MembroUseCaseImpl membroUseCase(MembroProvider membroProvider) {
        return new MembroUseCaseImpl(membroProvider);
    }

}
