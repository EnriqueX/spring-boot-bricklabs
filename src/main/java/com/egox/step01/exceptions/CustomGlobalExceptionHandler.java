package com.egox.step01.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

//@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), "From methodArgumentNotValid Exception", ex.getMessage());
        return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), "From HttpRequestMethodNotSupportedException Exception", ex.getMessage());
        return new ResponseEntity<>(customErrorDetails, HttpStatus.METHOD_NOT_ALLOWED);
    }

    //UsernameNotFound Exception Handler
    @ExceptionHandler(UsernameNotFoundException.class)
    public final ResponseEntity<Object> handleUsernameNotFound(UsernameNotFoundException ex, WebRequest request){
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(customErrorDetails, HttpStatus.NOT_FOUND);
    }

    //ConstrainViolation Exception (@Min)
    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstrainViolation(ConstraintViolationException ex, WebRequest request){
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
    }
}
