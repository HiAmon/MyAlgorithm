package com.amon.springbootdemo.exceptionhandler;

import com.amon.springbootdemo.error.GlobalError;
import com.amon.springbootdemo.exception.BuzzException;
import com.amon.springbootdemo.exception.FizzBuzzException;
import com.amon.springbootdemo.exception.FizzException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@ResponseBody
public class FizzbuzzExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FizzException.class)
    public ResponseEntity<GlobalError> fizzExceptionHandler(FizzException e){
        return new ResponseEntity(new GlobalError("123","21"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(BuzzException.class)
    public ResponseEntity<GlobalError> buzzExceptionHandler(BuzzException e){
        return new ResponseEntity(new GlobalError("123","21"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(FizzBuzzException.class)
    public ResponseEntity<GlobalError> fizzbuzzExceptionHandler(FizzBuzzException e){
        return new ResponseEntity(new GlobalError("123","21"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
