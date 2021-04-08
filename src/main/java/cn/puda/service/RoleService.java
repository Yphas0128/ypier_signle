package cn.puda.service;

import cn.puda.entity.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoleService {
    /**
     * 角色添加
     * @param role
     * @return
     */
    int create(Role role);

    /**
     * 角色添加资源
     * @param roleId
     * @param resourceIds
     * @return
     */
    @Transactional
    int allocResource(Long roleId, List<Long> resourceIds);
}
