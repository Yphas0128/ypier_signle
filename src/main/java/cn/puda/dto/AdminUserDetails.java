package cn.puda.dto;

import cn.puda.entity.Resource;
import cn.puda.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @title: AdminUserDetails
 * @Author Ypier
 * @Date: 2021/4/6 10:30
 */
public class AdminUserDetails implements UserDetails {
    private User user;
    private List<Resource> resourceList;

    public  AdminUserDetails(User user , List<Resource> resourceList){
        this.user = user;
        this.resourceList = resourceList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return resourceList.stream()
                .filter(resource -> resource.getUrl() != null)
                .map(resource -> new SimpleGrantedAuthority(resource.getUrl()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
