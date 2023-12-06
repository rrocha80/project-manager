package com.rodrigocarvalho.projectmanager.entrypoint.controller.request;

import com.rodrigocarvalho.projectmanager.core.domain.Pessoa;
import com.rodrigocarvalho.projectmanager.core.domain.Projeto;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.PessoaEntity;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.ProjetoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@Data
public class MembroRequest {
    private BigInteger id;
    private Projeto projeto;
    private Pessoa pessoa;
}
