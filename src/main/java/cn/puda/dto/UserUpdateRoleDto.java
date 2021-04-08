package cn.puda.dto;

import lombok.Data;

import java.util.List;

/**
 * @title: UserupdateRoleDto
 * @Author Ypier
 * @Date: 2021/4/6 15:54
 */
@Data
public class UserUpdateRoleDto {
    private Long userId;
    private List<Long> roleIds;
}
