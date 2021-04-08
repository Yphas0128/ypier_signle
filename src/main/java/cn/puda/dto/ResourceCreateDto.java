package cn.puda.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @title: ResourceCreateDto
 * @Author Ypier
 * @Date: 2021/4/6 16:25
 */
@Data
public class ResourceCreateDto {
    /**
     * 资源名称
     */
    private String name;
    /**
     * 资源url
     */
    @NotEmpty(message = "url不可为空")
    private String url;
    /**
     * 资源描述
     */
    private String description;
}
