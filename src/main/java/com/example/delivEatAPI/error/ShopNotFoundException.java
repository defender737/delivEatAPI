package com.example.delivEatAPI.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public class ShopNotFoundException extends RuntimeException {
    public ShopNotFoundException(String message) {
        super(message);
    }

    public ShopNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShopNotFoundException(String message, UUID shopId) {
        super(message + "shopId: " + shopId);
    }
}

