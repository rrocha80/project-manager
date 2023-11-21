package com.rodrigocarvalho.projectmanager.entrypoint.controller.mapper;

import com.rodrigocarvalho.projectmanager.core.domain.Projeto;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.request.ProjetoRequest;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.response.ProjetoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjetoMapper {
    Projeto toProjeto(ProjetoRequest projetoRequest);

    ProjetoResponse toProjetoResponse(Projeto projeto);

    List<ProjetoResponse> toProjetoResponseList(List<Projeto> projetos);
}
