package com.rodrigocarvalho.projectmanager.usecase;

import com.rodrigocarvalho.projectmanager.core.dataprovider.ProjetoProvider;
import com.rodrigocarvalho.projectmanager.core.domain.Enum.StatusEnum;
import com.rodrigocarvalho.projectmanager.core.usecase.Impl.ProjetoUseCaseImpl;
import com.rodrigocarvalho.projectmanager.core.usecase.ProjetoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import static com.rodrigocarvalho.projectmanager.buiders.MockBuilder.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles("teste")
public class ProjetoUseCaseTest {

    private ProjetoUseCase useCase;

    @Mock
    private ProjetoProvider provider;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        useCase = new ProjetoUseCaseImpl(provider);
    }
    @Test
    void inserirProjeto() {
        useCase.insert(buildMockInsertProjeto());
        Assertions.assertEquals(StatusEnum.INICIADO, buildMockInsertProjeto().getStatus());
    }

    @Test
    void removerProjeto() {
        assertThrows(RuntimeException.class, () -> useCase.delete(null));
    }

    @Test
    void removerProjetoIniciado() {
        assertThrows(RuntimeException.class, () -> useCase.delete(buildMockProjeto().getId()));
    }

    @Test
    void burcarTudoProjetos() {
        Mockito.when(useCase.findAll()).thenReturn(buildMockProjetos());
        Assertions.assertEquals(1, useCase.findAll().size());
    }
}
