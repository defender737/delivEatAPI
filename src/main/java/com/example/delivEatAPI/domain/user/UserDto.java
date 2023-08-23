package com.example.delivEatAPI.domain.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long userId;

    private String name;

    private String phoneNumber;

    private String address;
}
