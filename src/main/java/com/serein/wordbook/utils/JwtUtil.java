package com.serein.wordbook.utils;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.jwt.JWT;

import java.util.Date;
import java.util.Map;

/**
 * Jwt工具类
 *
 * @author 王强
 * @since  2023/11/16 23:03
 */
public class JwtUtil {

    private JwtUtil() {
    }

    /**
     * 密钥
     */
    private static final byte[] SECRET = "mh370".getBytes();

    /**
     * 过期时间 15分钟
     */
    public static final long EXPIRE = 15  * 60 * 1000L;

    /**
     * 生成 token
     * @return token
     */
    public static String generateToken(Map<String, Object> payload) {
        JWT jwt = JWT.create();
        payload.forEach(jwt::setPayload);
        jwt.setKey(SECRET).setExpiresAt(new Date(System.currentTimeMillis() + EXPIRE));
        return jwt.sign();
    }

    /**
     * 根据 userDto 生成 token
     * @param userDto 用户信息
     * @return token
     */
//    public static String generateTokenForUser(UserDto userDto) {
//        Map<String, Object> map = MapUtil.newHashMap();
//        map.put("id", userDto.getId());
//        map.put("username", userDto.getUsername());
//        return generateToken(map);
//    }

    /**
     * token 校验
     * @param token token
     * @return 是否通过校验
     */
    public static boolean verify(String token) {
        if (CharSequenceUtil.isBlank(token)) {
            return false;
        }
        JWT jwt;
        try {
            jwt = JWT.of(token).setKey(SECRET);
        } catch (Exception e) {
            return false;
        }
        return jwt.verify();
    }

    /**
     * token 校验，并获取 userDto
     * @param token token
     * @return userDto
     */
//    public static UserDto verifyAndGetUser(String token) {
//        if (!verify(token)) {
//            return null;
//        }
//        JWT jwt = JWT.of(token);
//        UserDto userDto = new UserDto();
//        userDto.setId(Long.valueOf(jwt.getPayload("id").toString()));
//        return userDto;
//    }

}
