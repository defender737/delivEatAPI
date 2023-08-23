package com.example.delivEatAPI.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void addUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        if(user == null){
            throw new RuntimeException("실패");
        }
        userRepository.save(user);
    }

    @Override
    public UserDto getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("해당 사용자를 찾을 수 없습니다. UserId: " + userId));

        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    @Modifying
    public void editMenu(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("해당 사용자를 찾을 수 없습니다. UserId: " + userId));

        if (userId.equals(userDto.getUserId())) {
            userMapper.updateFromDto(userDto, user);
        } else {
            throw new RuntimeException("사용자 정보 수정에 실패했습니다.");
        }
    }

    @Override
    public void deleteMenu(Long userId) {
        try {
            userRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("해당 사용자를 찾을 수 없습니다.");
        }
    }
}
