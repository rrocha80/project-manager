package com.rodrigocarvalho.projectmanager.dataprovider.repository.entity;

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

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "datanascimento")
    private LocalDate dataNascimento;

    @Column(name = "funcionario")
    private Boolean funcionario;

    @Column(name = "gerente")
    private Boolean gerente;
}
