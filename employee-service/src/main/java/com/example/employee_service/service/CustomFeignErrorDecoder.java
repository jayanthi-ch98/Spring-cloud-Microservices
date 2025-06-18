//package com.example.employee_service.service;
//
//import feign.Response;
//import feign.codec.ErrorDecoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomFeignErrorDecoder implements ErrorDecoder {
//
//    private final ErrorDecoder defaultDecoder = new Default();
//
//    @Override
//    public Exception decode(String methodKey, Response response) {
//        System.out.println("Feign error decoder triggered for: " + methodKey + " with status: " + response.status());
//        if (response.status() >= 400) {
//            // Example: Return RuntimeException so Resilience4j marks it as failure
//            return new RuntimeException("Feign Client Error: " + response.status() + " at " + methodKey);
//        }
//        return defaultDecoder.decode(methodKey, response);
//    }
//}
