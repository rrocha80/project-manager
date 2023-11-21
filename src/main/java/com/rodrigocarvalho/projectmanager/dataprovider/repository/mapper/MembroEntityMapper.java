package com.rodrigocarvalho.projectmanager.dataprovider.repository.mapper;

import com.rodrigocarvalho.projectmanager.core.domain.Membro;
import com.rodrigocarvalho.projectmanager.core.domain.Pessoa;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.MembroEntity;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.PessoaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MembroEntityMapper {
    MembroEntity toMembroEntity(Membro membro);

    Membro toMembro(MembroEntity membroEntity);

    List<Membro> toMembroList(List<MembroEntity> membroEntityList);
}
