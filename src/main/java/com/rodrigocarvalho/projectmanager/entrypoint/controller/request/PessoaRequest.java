package com.rodrigocarvalho.projectmanager.entrypoint.controller.request;

import com.rodrigocarvalho.projectmanager.core.domain.Enum.CargoEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
public class PessoaRequest {
    private BigInteger id;

    @NotBlank
    private String nome;

    @NotBlank
    private CargoEnum cargo;


    private LocalDate dataNascimento;


    private Boolean prjectFuncionario;
}
