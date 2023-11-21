package com.rodrigocarvalho.projectmanager.entrypoint.controller.mapper;

import com.rodrigocarvalho.projectmanager.core.domain.Membro;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.request.MembroRequest;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.response.MembroResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MembroMapper {
    Membro toMembro(MembroRequest membroRequest);

    MembroResponse toMembroResponse(Membro membro);

    List<MembroResponse> toMembroResponseList(List<Membro> membros);
}
