package com.rodrigocarvalho.projectmanager.dataprovider.repository.entity;

import com.rodrigocarvalho.projectmanager.core.domain.Enum.CargoEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pessoa")
public class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cargo", nullable = false)
    private CargoEnum cargo;

    @Column(name = "datanascimento")
    private LocalDate dataNascimento;

    @Column(name = "prjectfuncionario")
    private Boolean prjectFuncionario;
}
