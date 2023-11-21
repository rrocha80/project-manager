package com.rodrigocarvalho.projectmanager.dataprovider.repository.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ExceptionDto {
    private HttpStatus status;
    private String message;
}
