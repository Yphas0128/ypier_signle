package cn.puda.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.puda.dto.UserLoginDto;
import cn.puda.dto.UserRegisterDto;
import cn.puda.dto.UserUpdateRoleDto;
import cn.puda.entity.User;
import cn.puda.result.CommonResult;
import cn.puda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户
 * @title: UserController
 * @Author Ypier
 * @Date: 2021/4/6 8:34
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @PreAuthorize("hasAuthority('/user/test')")
    @GetMapping(value = "/test")
    public  CommonResult test(){
        return  CommonResult.success();
    }


    /**
     * 用户登录
     * @return
     */
    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody UserLoginDto userLoginDTO){
        String token = userService.login(userLoginDTO.getUsername(),userLoginDTO.getPassword());

        if (token == null){
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    /**
     * 用户注册
     * @return
     */
    @PostMapping(value = "/register")
    public CommonResult register(@RequestBody @Valid UserRegisterDto userRegisterDto,
                                 HttpServletRequest request){
        String ip = request.getRemoteAddr();
        User user = BeanUtil.toBean(userRegisterDto, User.class);
        user.setLoginIp(ip);
        int i =  userService.add(user);
        if(i > 0)
            return CommonResult.success();
        return CommonResult.failed("用户注册失败");
    }

    /**
     * 用户分配角色
     * @return
     */
    @PostMapping(value = "/role/update")
    public CommonResult updateRole(@RequestBody UserUpdateRoleDto userUpdateRoleDto){
       int count = userService.updateRole(userUpdateRoleDto.getUserId(),userUpdateRoleDto.getRoleIds());
       if(count > 0)
           return CommonResult.success();
       return CommonResult.failed("用户分配角色失败");
    }


}
