package com.example.delivEatAPI.domain.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
        return ResponseEntity.ok("사용자가 성공적으로 등록되었습니다. UserId: " + userDto.getUserId());
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long user_id) {
        UserDto userDto = userService.getUser(user_id);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{user_id}")
    public ResponseEntity<String> editUser(@PathVariable Long user_id, @RequestBody UserDto userDto) {
        userService.editMenu(user_id, userDto);
        return ResponseEntity.ok("사용자 정보가 성공적으로 수정되었습니다. UserId : " + user_id);
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<String> deleteMenu(@PathVariable Long user_id) {
        userService.deleteMenu(user_id);
        return ResponseEntity.ok("사용자가 성공적으로 삭제되었습니다. UserId: " + user_id);
    }

}
