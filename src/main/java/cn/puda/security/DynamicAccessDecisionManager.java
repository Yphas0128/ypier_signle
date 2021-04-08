package cn.puda.security;

import cn.hutool.core.collection.CollUtil;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;

import java.util.Collection;

/**
 * 动态权限决策管理器，用于判断用户是否有访问权限 未完成
 * @title: DynamicAccessDecisionManager
 * @Author Ypier
 * @Date: 2021/4/7 9:51
 */
public class DynamicAccessDecisionManager implements AccessDecisionManager {


    @Override
    public void decide(Authentication authentication, Object object,
                       Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        // 当接口未被配置资源时直接放行
        if(CollUtil.isEmpty(configAttributes)){
            return;
        }
        configAttributes.forEach(configAttribute->{
            String needAuthority = configAttribute.getAttribute();
            authentication.getAuthorities().forEach(grantedAuthority->{
                if(needAuthority.trim().equals(grantedAuthority.getAuthority()))
                    return;
            });
        });
        throw new AccessDeniedException("抱歉，您没有访问权限");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
