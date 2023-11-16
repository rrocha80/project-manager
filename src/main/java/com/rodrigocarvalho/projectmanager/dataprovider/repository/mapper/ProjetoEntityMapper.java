package com.rodrigocarvalho.projectmanager.dataprovider.repository.mapper;

import com.rodrigocarvalho.projectmanager.core.domain.Projeto;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.ProjetoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjetoEntityMapper {
    ProjetoEntity toProjetoEntity(Projeto projeto);

    Projeto toProjeto(ProjetoEntity projetoEntity);
}
