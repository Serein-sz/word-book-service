package com.serein.wordbook.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * user
 *
 * @author 王强
 * @since 2024/6/4 23:55
 */
@Data
@TableName("user_info")
public class User {

    @TableId
    private Long id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

}
