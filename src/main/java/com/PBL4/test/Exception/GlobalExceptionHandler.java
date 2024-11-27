package com.PBL4.test.Exception;

import com.PBL4.test.DTO.response.Api_Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value =  RuntimeException.class)
    ResponseEntity<String> handlingRuntimeException(Exception e){
        Api_Response apiResponse = new Api_Response();
        apiResponse.setCode(1001);
        apiResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(apiResponse.toString());

    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<Api_Response> handlingMethodArgumentNotValidException(MethodArgumentNotValidException e){
        String enumkey = e.getFieldError().getDefaultMessage();
        System.out.println(enumkey);
        ErrorCode errorcode = ErrorCode.valueOf(enumkey);
        Api_Response apiResponse = new Api_Response();
        apiResponse.setCode(errorcode.getCode());
        apiResponse.setMessage(errorcode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);


     }
    @ExceptionHandler(value =  AppException.class)
    ResponseEntity<Api_Response> handlingAppException(AppException e){
        ErrorCode errorcode = e.getErrorcode();
        Api_Response apiResponse = new Api_Response();
        apiResponse.setCode(errorcode.getCode());
        apiResponse.setMessage(errorcode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

}
