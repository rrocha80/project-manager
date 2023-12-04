package com.rodrigocarvalho.projectmanager.dataprovider.repository.entity;

import com.rodrigocarvalho.projectmanager.core.domain.Enum.RiscoEnum;
import com.rodrigocarvalho.projectmanager.core.domain.Enum.StatusEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "projeto")
public class ProjetoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_previsao_fim")
    private LocalDate dataPrevisao;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @Column(name = "descricao")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;

    @Column(name = "orcamento")
    private Float orcamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "risco")
    private RiscoEnum risco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idgerente", nullable = false)
    private PessoaEntity gerente;

    @ManyToMany()
    @JoinTable(
            name = "membros",
            joinColumns = @JoinColumn(name = "idprojeto"),
            inverseJoinColumns = @JoinColumn(name = "idpessoa")
    )
    private List<PessoaEntity> membros;
}
