package com.example.employee_service.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
        ErrorDetails errordetails=new ErrorDetails(LocalDateTime.now(), exception.getMessage(), "RESOURCE_NOT_FOUND", webRequest.getDescription(false));
       return new ResponseEntity<>(errordetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGeneralExceptions(Exception exception, WebRequest webRequest){
        ErrorDetails errordetails=new ErrorDetails(LocalDateTime.now(), exception.getMessage(), "INTERNAL_ERROR", webRequest.getDescription(false));
        return new ResponseEntity<>(errordetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<ObjectError> errorlist = ex.getBindingResult().getAllErrors();
        System.out.println(ex.getParameter());
        Map<String,String> errorMap= new HashMap<>();
        errorlist.stream() .forEach(error-> {
            errorMap.put(((FieldError) error).getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }
}

