package com.rodrigocarvalho.projectmanager.dataprovider.repository.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
