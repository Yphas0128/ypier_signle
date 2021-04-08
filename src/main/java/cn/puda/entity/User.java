package cn.puda.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * @title: User
 * @Author Ypier
 * @Date: 2021/4/6 9:02
 */
@Data
public class User implements Serializable {
    /**
     * 主键 自增
     */
    private long  id;
    /**
     * 密码
     */
    private  String password;
    /**
     * 用户名
     */
    private  String username;
    /**
     * 图标
     */
    private String icon;
    /**
     * 真实名字
     */
    private String nickName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 登录时间
     */
    private Date loginTime;
    /**
     * 登录Ip
     */
    private String loginIp;
    /**
     * 状态 0:已删除 1:未删除
     */
    private Integer status;
}
