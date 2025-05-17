package com.example.department_service.exception;

public class ResourceNotFoundException extends RuntimeException {
    private String message;
    private String fieldName;
    private String fieldValue;
    public ResourceNotFoundException(String message,String fieldName ,String fieldValue ){
        super(String.format("%s for %s :%s",message,fieldName,fieldValue));
    }
}
