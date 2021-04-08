package cn.puda.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.puda.entity.Role;
import cn.puda.entity.RoleResourceRelation;
import cn.puda.mapper.RoleMapper;
import cn.puda.mapper.RoleResourceMapper;
import cn.puda.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @title: RoleServiceImpl
 * @Author Ypier
 * @Date: 2021/4/6 15:27
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleResourceMapper roleResourceMapper;
    /**
     * 添加角色
     * @param role
     * @return
     */
    @Override
    public int create(Role role) {
        DateTime now = DateUtil.date();
        role.setCreateTime(now);
        if(role.getSort() == null || !role.getSort().equals(0)){
            role.setSort(0);
        }
        int count = roleMapper.insert(role);
        return count;
    }

    /**
     * 角色分配资源
     * @param roleId
     * @param resourceIds
     * @return
     */
    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        int count  = resourceIds == null ? 0 : resourceIds.size();
        roleResourceMapper.deleteAll(roleId);
        List<RoleResourceRelation> list = resourceIds.stream().map(resourceId -> {
            RoleResourceRelation roleResourceRelation = new RoleResourceRelation();
            roleResourceRelation.setResourceId(resourceId);
            roleResourceRelation.setRoleId(roleId);
            return roleResourceRelation;
        }).collect(Collectors.toList());
        roleResourceMapper.insertList(list);
        return count;
    }
}
