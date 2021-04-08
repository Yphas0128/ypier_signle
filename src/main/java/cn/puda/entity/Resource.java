package cn.puda.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 资源表
 * @title: Permission
 * @Author Ypier
 * @Date: 2021/4/6 10:34
 */
@Data
public class Resource implements Serializable {
    /**
     * 主键
     */
    private long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 资源url
     */
    private String url;
    /**
     * 资源描述
     */
    private String description;
}
