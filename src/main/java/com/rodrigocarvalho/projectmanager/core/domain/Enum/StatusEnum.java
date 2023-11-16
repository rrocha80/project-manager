package com.rodrigocarvalho.projectmanager.core.domain.Enum;

public enum StatusEnum {
    EM_ANALISE("Em Análise"),
    ANALISE_REALIZADA("Análise Realizada"),
    ANALISE_APROVADA("Análise Aprovada"),
    INICIADO("Iniciado"),
    PLANEJADO("Planejado"),
    EM_ANDAMENTO("Em Andamento"),
    ENCERRADO("Encerrado"),
    CANCELADO("Cancelado");

    private String descicao;

    StatusEnum(String descricao) {
        this.descicao = descricao;
    }

    public String getDescicao() {
        return descicao;
    }

}
