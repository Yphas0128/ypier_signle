package cn.puda.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.puda.entity.Resource;
import cn.puda.mapper.ResourceMapper;
import cn.puda.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @title: ResourceServiceImpl
 * @Author Ypier
 * @Date: 2021/4/6 16:33
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public int insertResouce(Resource resource) {
        DateTime now = DateUtil.date();
        resource.setCreateTime(now);
        int count = resourceMapper.insert(resource);
        return count;
    }
}
