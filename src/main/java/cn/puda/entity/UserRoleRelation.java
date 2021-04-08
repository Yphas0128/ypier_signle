package cn.puda.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @title: UserRoleRelation
 * @Author Ypier
 * @Date: 2021/4/6 16:06
 */
@Data
public class UserRoleRelation implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 关联用户id
     */
    private long userId;
    /**
     * 关联角色id
     */
    private long roleId;
}
