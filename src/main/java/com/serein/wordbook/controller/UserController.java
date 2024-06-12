package com.serein.wordbook.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.serein.wordbook.entity.User;
import com.serein.wordbook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * user controller
 *
 * @author 王强
 * @since 2024/6/4 23:52
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public User hello() {
        return userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, "2"));
    }

}
