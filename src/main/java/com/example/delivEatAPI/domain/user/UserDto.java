package com.example.delivEatAPI.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    private UUID id;

    private String name;

    private String phoneNumber;

    private String address;

}
