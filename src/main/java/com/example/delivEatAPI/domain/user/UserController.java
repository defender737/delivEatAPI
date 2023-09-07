package com.example.delivEatAPI.domain.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> addUser(@Valid @RequestBody UserDto userDto) {
        userService.addUser(userDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("사용자가 등록되었습니다.");
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<UserDto> getUser(@PathVariable UUID user_id) {
        UserDto userDto = userService.getUser(user_id);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping
    public ResponseEntity<String> editUser(@Valid @RequestBody UserDto userDto) {
        userService.editMenu(userDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("사용자가 수정되었습니다.");
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<String> deleteMenu(@PathVariable UUID user_id) {
        userService.deleteMenu(user_id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("사용자가 삭제되었습니다.");
    }
}
