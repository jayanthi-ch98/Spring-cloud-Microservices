package com.example.department_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ErrorDetails {

    private LocalDateTime dateTime;
    private String errorMessage;
    private String errorCode;
    private String description;

}

