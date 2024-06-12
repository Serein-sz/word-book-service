package com.serein.wordbook.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.serein.wordbook.entity.User;
import com.serein.wordbook.mapper.UserMapper;
import com.serein.wordbook.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
