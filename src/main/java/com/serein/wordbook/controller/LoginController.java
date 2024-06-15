package com.serein.wordbook.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.serein.wordbook.common.Response;
import com.serein.wordbook.entity.User;
import com.serein.wordbook.entity.dto.UserDto;
import com.serein.wordbook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 王强
 * @since 2024/6/15 22:04
 */
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping
    public SaResult login(@RequestBody UserDto userDto) {
        User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, userDto.getUsername()));
        if (user.getPassword().equals(userDto.getPassword())) {
            StpUtil.login(user.getId());
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return SaResult.data(tokenInfo);
        }
        return SaResult.error("login failure");
    }
}
