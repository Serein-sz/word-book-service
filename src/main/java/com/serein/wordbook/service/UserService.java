package com.serein.wordbook.service;

import com.serein.wordbook.entity.User;
import com.serein.wordbook.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * user service
 *
 * @author 王强
 * @since 2024/6/4 23:53
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public User findByUsername(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }

}
