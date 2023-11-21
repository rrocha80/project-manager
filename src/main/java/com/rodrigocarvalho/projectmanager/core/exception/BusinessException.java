package com.rodrigocarvalho.projectmanager.core.exception;

//@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public BusinessException(String mensagem) {
        super(mensagem);
    }

    public BusinessException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
