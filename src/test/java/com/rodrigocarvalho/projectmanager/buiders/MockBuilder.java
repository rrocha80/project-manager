package com.rodrigocarvalho.projectmanager.buiders;

import com.rodrigocarvalho.projectmanager.core.domain.Enum.CargoEnum;
import com.rodrigocarvalho.projectmanager.core.domain.Enum.RiscoEnum;
import com.rodrigocarvalho.projectmanager.core.domain.Enum.StatusEnum;
import com.rodrigocarvalho.projectmanager.core.domain.Pessoa;
import com.rodrigocarvalho.projectmanager.core.domain.Projeto;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockBuilder {
    public static List<Pessoa> buildMockPessoas() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(BigInteger.valueOf(7));
        pessoa.setNome("Giovany");
        pessoa.setCargo(CargoEnum.DESENVOLVEDOR);
        pessoa.setDataNascimento(LocalDate.of(2000, 10, 01));
        pessoa.setPrjectFuncionario(false);

        List<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(pessoa);

        return pessoas;
    }

    public static Pessoa buildMockPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(BigInteger.valueOf(7));
        pessoa.setNome("Giovany");
        pessoa.setCargo(CargoEnum.DESENVOLVEDOR);
        pessoa.setDataNascimento(LocalDate.of(2000, 10, 01));
        pessoa.setPrjectFuncionario(false);

        return pessoa;
    }

    public static Pessoa buildMockInsertPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Giovany");
        pessoa.setCargo(CargoEnum.DESENVOLVEDOR);
        pessoa.setDataNascimento(LocalDate.of(2000, 10, 01));
        pessoa.setPrjectFuncionario(false);

        return pessoa;
    }

    public static List<Projeto> buildMockProjetos() {
        Projeto projeto = new Projeto();
        projeto.setId(BigInteger.ONE);
        projeto.setStatus(StatusEnum.INICIADO);
        projeto.setNome("Teste projeto");
        projeto.setDataFim(LocalDate.of(2023, 12, 05));
        projeto.setDescricao("Teste projeto test");
        projeto.setDataInicio(LocalDate.of(2023, 10, 01));
        projeto.setGerente(buildMockPessoa());
        projeto.setDataPrevisao(LocalDate.of(2023, 12, 01));
        projeto.setOrcamento(50000f);
        projeto.setRisco(RiscoEnum.BAIXO_RISCO);

        List<Projeto> projetos = new ArrayList<>();
        projetos.add(projeto);

        return projetos;
    }

    public static Projeto buildMockProjeto() {
        Projeto projeto = new Projeto();
        projeto.setId(BigInteger.ONE);
        projeto.setStatus(StatusEnum.INICIADO);
        projeto.setNome("Teste projeto");
        projeto.setDataFim(LocalDate.of(2023, 12, 05));
        projeto.setDescricao("Teste projeto test");
        projeto.setDataInicio(LocalDate.of(2023, 10, 01));
        projeto.setGerente(buildMockPessoa());
        projeto.setDataPrevisao(LocalDate.of(2023, 12, 01));
        projeto.setOrcamento(50000f);
        projeto.setRisco(RiscoEnum.BAIXO_RISCO);

        return projeto;
    }

    public static Projeto buildMockInsertProjeto() {
        Projeto projeto = new Projeto();
        projeto.setStatus(StatusEnum.INICIADO);
        projeto.setNome("Teste projeto");
        projeto.setDataFim(LocalDate.of(2023, 12, 05));
        projeto.setDescricao("Teste projeto test");
        projeto.setDataInicio(LocalDate.of(2023, 10, 01));
        projeto.setGerente(buildMockPessoa());
        projeto.setDataPrevisao(LocalDate.of(2023, 12, 01));
        projeto.setOrcamento(50000f);
        projeto.setRisco(RiscoEnum.BAIXO_RISCO);

        return projeto;
    }
}
