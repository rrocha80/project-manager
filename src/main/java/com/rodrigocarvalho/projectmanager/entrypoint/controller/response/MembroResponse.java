package com.rodrigocarvalho.projectmanager.entrypoint.controller.response;

import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.PessoaEntity;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.ProjetoEntity;
import lombok.Data;

import java.math.BigInteger;

@Data
public class MembroResponse {
    private BigInteger id;
    private ProjetoEntity projeto;
    private PessoaEntity pessoa;
}
