package com.rodrigocarvalho.projectmanager.core.exception;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MyEntityNotFoundException extends BusinessException{

    private static final long serialVersionUID = 1L;

    public MyEntityNotFoundException(String mensagem) {
        super(mensagem);
    }
}
