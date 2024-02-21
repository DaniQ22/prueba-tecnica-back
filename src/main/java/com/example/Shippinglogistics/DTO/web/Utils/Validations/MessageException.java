package com.example.Shippinglogistics.DTO.web.Utils.Validations;

public class MessageException extends RuntimeException{
    public MessageException(String message) {
        super(message);
    }

    public MessageException(String message, Throwable cause) {
        super(message, cause);
    }
}
