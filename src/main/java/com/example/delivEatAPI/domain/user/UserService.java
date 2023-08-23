package com.example.delivEatAPI.domain.user;

public interface UserService {
    void addUser(UserDto userDto);

    UserDto getUser(Long user_id);

    void editMenu(Long user_id, UserDto menuDto);

    void deleteMenu(Long user_id);
}
