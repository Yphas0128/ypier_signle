package cn.puda.dto;

import lombok.Data;
import java.util.List;

/**
 *
 * @title: RoleAllocResource
 * @Author Ypier
 * @Date: 2021/4/6 16:43
 */
@Data
public class RoleAllocResourceDto {
    private Long roleId;
    private List<Long> resourceIds;
}
