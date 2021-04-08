package cn.puda.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.puda.dto.RoleAllocResourceDto;
import cn.puda.dto.RoleCreateDto;
import cn.puda.entity.Role;
import cn.puda.result.CommonResult;
import cn.puda.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * 角色
 * @title: RoleController
 * @Author Ypier
 * @Date: 2021/4/6 15:24
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 角色添加
     * @return
     */
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody @Valid RoleCreateDto roleCreateDto){
        Role role = BeanUtil.toBean(roleCreateDto, Role.class);
        int count = roleService.create(role);
        if(count == 0)
            return CommonResult.failed("角色添加失败");
        return CommonResult.success();
    }

    /**
     * 角色分配资源
     * @return
     */
    @PostMapping(value = "/allocResource")
    public CommonResult allocResource(@RequestBody RoleAllocResourceDto roleAllocResourceDto){
        int count =  roleService.allocResource(roleAllocResourceDto.getRoleId(),roleAllocResourceDto.getResourceIds());
        if(count > 0)
            return CommonResult.success();
        return  CommonResult.failed();
    }

}
