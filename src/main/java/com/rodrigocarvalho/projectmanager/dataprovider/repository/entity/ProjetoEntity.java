package com.rodrigocarvalho.projectmanager.dataprovider.repository.entity;

import com.rodrigocarvalho.projectmanager.core.domain.Enum.RiscoEnum;
import com.rodrigocarvalho.projectmanager.core.domain.Enum.StatusEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "projeto")
public class ProjetoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_previsao", nullable = false)
    private LocalDate dataPrevisao;

    @Column(name = "data_fim", nullable = false)
    private LocalDate dataFim;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "status", nullable = false)
    private StatusEnum status;

    @Column(name = "orcamento", nullable = false)
    private float orcamento;

    @Column(name = "risco", nullable = false)
    private RiscoEnum risco;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idgerente", nullable = false)
    private PessoaEntity gerente;
}
