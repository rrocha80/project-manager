package com.rodrigocarvalho.projectmanager.entrypoint.controller.mapper;

import com.rodrigocarvalho.projectmanager.core.domain.Pessoa;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.request.PessoaRequest;
import com.rodrigocarvalho.projectmanager.entrypoint.controller.response.PessoaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    //@Mapping(target = "id", ignore = true)
    Pessoa toPessoa(PessoaRequest pessoaRequest);

    PessoaResponse toPessoaResponse(Pessoa pessoa);

    List<PessoaResponse> toPessoaResponseList(List<Pessoa> pessoas);
}
