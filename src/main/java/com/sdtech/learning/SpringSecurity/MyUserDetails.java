package com.sdtech.learning.SpringSecurity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails
{
    /**
     * 
     */
    private static final long serialVersionUID = -8718095136088443431L;
    private String userName;
    private String password;
    private boolean isEnabled;
    private List<GrantedAuthority> authorities;

    public MyUserDetails( String userName,
        String password,
        boolean isEnabled,
        List<GrantedAuthority> authorities )
    {
        this.userName = userName;
        this.password = password;
        this.isEnabled = isEnabled;
        this.authorities = authorities;

    }

    public MyUserDetails()
    {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {

        return this.authorities;
    }

    @Override
    public String getPassword()
    {

        return this.password;
    }

    @Override
    public String getUsername()
    {

        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired()
    {

        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {

        return true;
    }

    @Override
    public boolean isEnabled()
    {

        return this.isEnabled;
    }

}
