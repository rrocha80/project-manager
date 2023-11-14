package com.rodrigocarvalho.projectmanager.dataprovider.repository.mapper;

import com.rodrigocarvalho.projectmanager.core.domain.Pessoa;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.PessoaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PessoaEntityMapper {

    PessoaEntity toPessoaEntity(Pessoa pessoa);

    Pessoa toPessoa(PessoaEntity pessoaEntity);

    List<Pessoa> toPessoaList(List<PessoaEntity> pessoaEntityList);

}
