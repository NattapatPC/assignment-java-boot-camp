package com.exampleas.shoppingapp.products;

import com.exampleas.shoppingapp.products.Exception.NotFoundException;
import com.exampleas.shoppingapp.products.Response.NotFoundExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler({NotFoundException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public NotFoundExceptionResponse userNotFound(NotFoundException error) {
        return new NotFoundExceptionResponse(error.getMessage());
    }

}
