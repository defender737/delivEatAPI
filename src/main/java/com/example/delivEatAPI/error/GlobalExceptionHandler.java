package com.example.delivEatAPI.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidException(MethodArgumentNotValidException e) {
        ErrorCode errorCode = ErrorCode.INVALID_INPUT_VALUE;
        BindingResult bindingResult = e.getBindingResult();

        log.error("Validation error occurred: {}", e.getMessage(), e);

        StringBuilder builder = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            builder.append("[");
            builder.append(fieldError.getField());
            builder.append("](은)는 ");
            builder.append(fieldError.getDefaultMessage());
            builder.append(". ");
        }
        builder.deleteCharAt(builder.length() - 1);

        final ErrorResponse response = new ErrorResponse(errorCode.getCode(), builder.toString());
        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
        ErrorCode errorCode = e.getErrorCode();
        log.error("Business exception occurred: {}", e.getMessage(), e);
        ErrorResponse response = new ErrorResponse(errorCode.getCode(), e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        log.error("Unexpected exception occurred: {}", e.getMessage(), e);
        ErrorResponse response = new ErrorResponse(errorCode.getCode(), e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
    }
}
