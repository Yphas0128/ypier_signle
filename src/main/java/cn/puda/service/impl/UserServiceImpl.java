package cn.puda.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.puda.entity.Resource;
import cn.puda.entity.User;
import cn.puda.entity.UserRoleRelation;
import cn.puda.mapper.UserMapper;
import cn.puda.mapper.UserRoleRelationMapper;
import cn.puda.service.UserService;
import cn.puda.util.JwtTokenUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @title: UserServiceImpl
 * @Author Ypier
 * @Date: 2021/4/6 8:35
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserRoleRelationMapper userRoleRelationMapper;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @param username
     * @return
     */
    @Override
    public User selectUserByUsername(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        User user = userMapper.selectOne(wrapper);
        return user;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public List<Resource> getResourcelist(Long id) {
        return userRoleRelationMapper.getResourceList(id);
    }

    /**
     * ????????????
     * @param username
     * @param password
     * @return
     */
    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("???????????????");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // ??????token
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            log.warn("????????????:{}", e.getMessage());
        }
        return token;
    }

    /**
     * ????????????
     * @param user
     * @return
     */
    @Override
    public int add(User user) {
        DateTime now = DateUtil.date();
        user.setCreateTime(now);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int i = userMapper.insert(user);
        return i;
    }

    /**
     * ??????????????????
     * @param userId
     * @param roleIds
     * @return
     */
    @Override
    public int updateRole(Long userId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //????????? userId ?????????
        userRoleRelationMapper.deleteAll(userId);

        if(roleIds != null && roleIds.size() !=0){
            List<UserRoleRelation> list = roleIds.stream().map(roleId -> {
                UserRoleRelation roleRelation = new UserRoleRelation();
                roleRelation.setUserId(userId);
                roleRelation.setRoleId(roleId);
                return roleRelation;
            }).collect(Collectors.toList());
            userRoleRelationMapper.insertAll(list);
        }
        return count;
    }

}
