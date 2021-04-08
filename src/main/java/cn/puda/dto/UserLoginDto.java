package cn.puda.dto;

import lombok.Data;

/**
 * 用户登录参数
 * @title: UserLoginDTO
 * @Author Ypier
 * @Date: 2021/4/6 13:15
 */
@Data
public class UserLoginDto {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
