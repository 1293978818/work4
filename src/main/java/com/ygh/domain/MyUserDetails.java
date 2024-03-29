package com.ygh.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 处理用户登录的类
 * @author ygh
 */
public class MyUserDetails implements UserDetails{

    private final User user;

    public MyUserDetails(User user){
        this.user = user;
    }

    public User getUser(){
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        String password = user.getPassword();
        user.setPassword(null);
        return password;
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
        return user.getDeleted().equals(0);
    }
    
}
