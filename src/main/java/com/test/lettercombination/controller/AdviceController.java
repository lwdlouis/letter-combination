package com.test.lettercombination.controller;


import com.test.lettercombination.dto.ApiRespDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ApiRespDTO handleNotValidException(MethodArgumentNotValidException ex) {
        log.info("Not Valid Exception {}", ex.getMessage());
        return ApiRespDTO.ofInvalid(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }


    @ExceptionHandler(value = {Exception.class})
    public ApiRespDTO handleException(Exception ex) {
        log.info("Exception", ex);
        return ApiRespDTO.ofFail("System error, please contact system admin.");
    }

}
