package com.example.employee_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorDetails {

    private LocalDateTime dateTime;
    private String errorMessage;
    private String errorCode;
    private String description;

}
