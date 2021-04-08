package cn.puda.security;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * @title: DynamicSecurityService
 * @Author Ypier
 * @Date: 2021/4/7 9:34
 */
public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}
