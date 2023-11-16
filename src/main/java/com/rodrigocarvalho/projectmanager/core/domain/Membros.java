package com.rodrigocarvalho.projectmanager.core.domain;

import java.math.BigInteger;

public class Membros {

    public Membros(){}

    public Membros(Pessoa pessoa, Projeto projeto) {
        this.pessoa = pessoa;
        this.projeto = projeto;
    }

    private Pessoa pessoa;
    private Projeto projeto;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}
