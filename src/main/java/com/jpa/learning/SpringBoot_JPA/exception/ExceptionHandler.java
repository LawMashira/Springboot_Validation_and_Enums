package com.jpa.learning.SpringBoot_JPA.exception;

import com.jpa.learning.SpringBoot_JPA.exception.inside.CourseNotFoundEXception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String>handleInvalidData (MethodArgumentNotValidException ex){
        Map<String,String> errorMap = new HashMap();
        ex.getBindingResult().getFieldErrors().forEach(error->{
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return  errorMap;

    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

    @org.springframework.web.bind.annotation.ExceptionHandler(CourseNotFoundEXception.class)
    public  Map<String ,String  > handleNotFoundException(CourseNotFoundEXception ex){
        Map<String,String> errorMap = new HashMap();
        errorMap.put("errorMessage",ex.getMessage());
        return  errorMap;
    }
}