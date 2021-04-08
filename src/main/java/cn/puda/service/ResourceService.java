package cn.puda.service;

import cn.puda.entity.Resource;

/**
 * @title: ResourceService
 * @Author Ypier
 * @Date: 2021/4/6 16:33
 */
public interface ResourceService {

    /**
     * 添加资源
     * @param resource
     * @return
     */
    int insertResouce(Resource resource);
}
