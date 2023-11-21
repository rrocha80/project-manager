package com.rodrigocarvalho.projectmanager.core.domain;

import java.math.BigInteger;

public class Membro {

    public Membro(){}

    public Membro(BigInteger id, Projeto projeto, Pessoa pessoa) {
        this.id = id;
        this.projeto = projeto;
        this.pessoa = pessoa;
    }

    private BigInteger id;

    private Projeto projeto;

    private Pessoa pessoa;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
