package com.codeandscale.bowling.configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ApiErrorException.class)
  protected ResponseEntity<ErrorResponse> handleError(RuntimeException ex) {
    ApiErrorException errorException = (ApiErrorException) ex;
    return ResponseEntity
      .status(HttpStatus.valueOf(errorException.getErrorResponse().getStatus()))
      .body(errorException.getErrorResponse());
  }
}
