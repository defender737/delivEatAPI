package com.example.delivEatAPI.error.commonException;

import com.example.delivEatAPI.error.BusinessException;
import com.example.delivEatAPI.error.ErrorCode;

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
