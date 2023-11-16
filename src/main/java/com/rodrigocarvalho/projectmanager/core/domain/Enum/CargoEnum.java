package com.rodrigocarvalho.projectmanager.core.domain.Enum;

public enum CargoEnum {
    GERENTE("Gerente"),
    ANALISTA("Analista"),
    DESENVOLVEDOR("Desenvolvedor"),
    QA("Analista de Qualidade"),
    AGILISTA("Agilista"),
    PO("Product Owner"),
    TECH_LEADER("Tech Leader");

    private String descicao;

    CargoEnum(String descricao) {
        this.descicao = descricao;
    }

    public String getDescicao() {
        return descicao;
    }
}
