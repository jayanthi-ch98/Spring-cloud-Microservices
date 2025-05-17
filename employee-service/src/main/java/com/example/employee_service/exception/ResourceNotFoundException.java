package com.example.employee_service.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String fieldName,String fieldValue,String message ){
        super(String.format("%s does not exists at %s :%s",fieldValue,fieldName,message));
    }
}
