//package com.example.employee_service.service;
//
//import com.example.employee_service.dto.APIResponseDto;
//import java.util.function.Predicate;
//
//public class MyCustomResultPredicate implements Predicate<APIResponseDto> {
//
//    @Override
//    public boolean test(APIResponseDto response) {
//        if (response != null && response.getDepartmentDto() != null) {
//            return "R&D department".equals(response.getDepartmentDto().getDepartmentName());
//        }
//        return false;
//    }
//}
