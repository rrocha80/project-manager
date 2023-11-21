package com.rodrigocarvalho.projectmanager.core.exception;

import java.math.BigInteger;


public class RecNotFountException extends MyEntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public RecNotFountException(String mensagem) {
        super(mensagem);
    }

    public RecNotFountException(BigInteger id) {
        this(String.format("Registro não encontrado com o ID: %d", id));
    }
}
