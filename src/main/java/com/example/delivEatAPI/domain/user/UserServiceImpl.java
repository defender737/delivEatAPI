package com.example.delivEatAPI.domain.user;


import com.example.delivEatAPI.error.commonException.EntityNotFoundException;
import com.example.delivEatAPI.error.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public void addUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userRepository.save(user);
    }

    @Override
    @Transactional

    public UserDto getUser(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.USER_NOT_FOUND, "해당 사용자를 찾을 수 없습니다."));
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    @Modifying
    public void editMenu(UserDto userDto) {
        UUID userId = userDto.getId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.USER_NOT_FOUND, "해당 사용자를 찾을 수 없습니다."));
        user.update(userDto.getName(), userDto.getPhoneNumber(), userDto.getAddress());
        userRepository.save(user);
    }


    @Override
    @Transactional

    public void deleteMenu(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.USER_NOT_FOUND, "해당 사용자를 찾을 수 없습니다."));
        userRepository.delete(user);
    }
}
