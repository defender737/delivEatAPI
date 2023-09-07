package com.example.delivEatAPI.global.config;

import java.time.LocalDateTime;

public class DateTimeProvider {

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
}
