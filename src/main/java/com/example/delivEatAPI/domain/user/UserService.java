package com.example.delivEatAPI.domain.user;

import java.util.UUID;

public interface UserService {
    void addUser(UserDto userDto);

    UserDto getUser(UUID user_id);

    void editMenu(UserDto menuDto);

    void deleteMenu(UUID user_id);
}
