package cn.puda.entity;

import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @title: Role
 * @Author Ypier
 * @Date: 2021/4/6 15:29
 */
@Data
public class Role implements Serializable {
    /**
     *主键
     */
    private long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 顺序
     */
    private Integer sort;
}
