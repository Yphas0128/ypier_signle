package cn.puda.dto;

import io.swagger.models.auth.In;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @title: RoleCreateDto
 * @Author Ypier
 * @Date: 2021/4/6 15:33
 */
@Data
public class RoleCreateDto {
    /**
     * 名称
     */
    @NotEmpty(message = "角色名称不可为空")
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 排序
     */
    private Integer sort;
}
