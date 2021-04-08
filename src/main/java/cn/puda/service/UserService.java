package cn.puda.service;

import cn.puda.entity.Resource;
import cn.puda.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    /**
     * 根据用户名获取用户
     */
   User selectUserByUsername(String username);

    /**
     * 根据 用户id 获取 权限
     */
    List<Resource> getResourcelist(Long id);

    /**
     * 用户登录 返回token
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 用户添加
     * @param user
     * @return
     */
    int add(User user);

    /**
     * 用户分配角色
     * @param userId
     * @param roleIds
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int updateRole(Long userId, List<Long> roleIds);
}
