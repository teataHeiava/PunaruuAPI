package com.punaruu.igestion.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {

    /**
     * Toute les autres exceptions
     *
     * @param exception l'exception
     * @param request   la requète
     *
     * @return l'exception
     */
    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<Object> handleException(RuntimeException exception, WebRequest request) {
        return handleExceptionInternal(exception, exception.getMessage(), new HttpHeaders(),
                HttpStatus.BAD_REQUEST, request);
    }

    /**
     * Exception dans le cas d'une exception revatua
     *
     * @param exception l'exception
     * @param request   la requète
     *
     * @return l'exception
     */
    @ExceptionHandler(value = {IgestionException.class})
    public ResponseEntity<Object> handleException(IgestionException exception, WebRequest request) {
        return handleExceptionInternal(exception, exception.getErrorMessage(), new HttpHeaders(),
                HttpStatus.BAD_REQUEST, request);
    }
}
