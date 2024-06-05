package com.serein.wordbook.mapper;

import com.serein.wordbook.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * user mapper
 *
 * @author 王强
 * @since 2024/6/4 23:50
 */
public interface UserMapper {

    User findByUsername(@Param("username") String username);

}
