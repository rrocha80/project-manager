package com.rodrigocarvalho.projectmanager.entrypoint.controller.request;

import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.PessoaEntity;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.ProjetoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class MembroRequest {
    private BigInteger id;
    private ProjetoEntity projeto;
    private PessoaEntity pessoa;
}
