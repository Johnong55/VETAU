package com.PBL4.test.Exception;

import com.PBL4.test.DTO.request.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value =  RuntimeException.class)
    ResponseEntity<String> handlingRuntimeException(Exception e){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(1001);
        apiResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(apiResponse.toString());

    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingMethodArgumentNotValidException(MethodArgumentNotValidException e){
        String enumkey = e.getFieldError().getDefaultMessage();
        System.out.println(enumkey);
        ErrorCode errorcode = ErrorCode.valueOf(enumkey);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(errorcode.getCode());
        apiResponse.setMessage(errorcode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);


     }
    @ExceptionHandler(value =  AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException e){
        ErrorCode errorcode = e.getErrorcode();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(errorcode.getCode());
        apiResponse.setMessage(errorcode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

}
