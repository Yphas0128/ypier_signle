package cn.puda.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @title: UserRegisterDto
 * @Author Ypier
 * @Date: 2021/4/6 14:57
 */
@Data
public class UserRegisterDto {
    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不可为空")
    private String username;
    /**
     * 密码
     */
    @NotEmpty(message = "密码不可为空")
    private String password;
    /**
     * 图标
     */
    private String icon;
    /**
     * 姓名
     */
    @NotEmpty(message = "姓名不可为空")
    private String nickName;
}
