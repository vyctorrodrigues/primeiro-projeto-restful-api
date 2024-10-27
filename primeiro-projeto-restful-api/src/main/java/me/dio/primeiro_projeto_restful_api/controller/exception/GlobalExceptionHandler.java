package me.dio.primeiro_projeto_restful_api.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {

   private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
  
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException){
      return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable NotFoundException){
        var message = "Unexpected server error, see the logs";
        logger.error(message, NotFoundException);
      return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}