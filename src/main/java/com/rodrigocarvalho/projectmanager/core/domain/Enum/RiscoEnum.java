package com.rodrigocarvalho.projectmanager.core.domain.Enum;

public enum RiscoEnum {
    BAIXO_RISCO("Baixo Risco"),
    MEDIO_RISCO("Médio Risco"),
    ALTO_RISCO("Alto Risco");

    private String descicao;

    RiscoEnum(String descricao) {
        this.descicao = descricao;
    }

    public String getDescicao() {
        return descicao;
    }
}
