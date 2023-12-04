package com.rodrigocarvalho.projectmanager.usecase;

import com.rodrigocarvalho.projectmanager.core.dataprovider.PessoaProvider;
import com.rodrigocarvalho.projectmanager.core.usecase.Impl.PessoaUseCaseImpl;
import com.rodrigocarvalho.projectmanager.core.usecase.PessoaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import static com.rodrigocarvalho.projectmanager.buiders.MockBuilder.buildMockInsertPessoa;
import static com.rodrigocarvalho.projectmanager.buiders.MockBuilder.buildMockPessoas;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ActiveProfiles("teste")
public class PessoaUseCaseTest {

    private PessoaUseCase useCase;

    @Mock
    private PessoaProvider provider;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        useCase = new PessoaUseCaseImpl(provider);
    }

    @Test
    void inserirPessoa() {

        useCase.insert(buildMockInsertPessoa());
        Assertions.assertEquals("Giovany", buildMockInsertPessoa().getNome());

    }

    @Test
    void removerPessoa() {
        assertThrows(RuntimeException.class, () -> useCase.delete(null));
    }

    @Test
    void burcarTudoPessoas() {
        Mockito.when(useCase.findAll()).thenReturn(buildMockPessoas());
        Assertions.assertEquals(1, useCase.findAll().size());
    }
}
