package com.exampleas.shoppingapp.products.Response;

public class NotFoundExceptionResponse {
    private String message;

    public NotFoundExceptionResponse() {

    }

    public NotFoundExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
