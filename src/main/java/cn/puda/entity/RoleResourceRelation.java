package cn.puda.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @title: RoleUserRelation
 * @Author Ypier
 * @Date: 2021/4/6 16:53
 */
@Data
public class RoleResourceRelation implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 资源id
     */
    private Long resourceId;
}
