package cn.puda.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.puda.dto.ResourceCreateDto;
import cn.puda.entity.Resource;
import cn.puda.result.CommonResult;
import cn.puda.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * 资源
 * @title: ResourceController
 * @Author Ypier
 * @Date: 2021/4/6 16:21
 */
@RestController
@RequestMapping(value = "/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 资源添加
     * @return
     */
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody @Valid ResourceCreateDto resourceCreateDto){
        Resource resource = BeanUtil.toBean(resourceCreateDto, Resource.class);
        int count = resourceService.insertResouce(resource);
        if(count>0)
            return CommonResult.success();
        return CommonResult.failed("资源添加失败");
    }


}
