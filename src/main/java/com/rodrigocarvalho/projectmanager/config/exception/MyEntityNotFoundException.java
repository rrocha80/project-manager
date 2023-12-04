package com.rodrigocarvalho.projectmanager.config.exception;

public class MyEntityNotFoundException extends BusinessException{

    private static final long serialVersionUID = 1L;

    public MyEntityNotFoundException(String mensagem) {
        super(mensagem);
    }
}
