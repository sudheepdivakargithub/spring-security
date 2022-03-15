package com.sdtech.learning.SpringSecurity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService
{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername( String userName ) throws UsernameNotFoundException
    {

        User user = userRepository.findByUserName( userName ).orElseThrow( () -> new UsernameNotFoundException( "User not found" ) );

        List<GrantedAuthority> authorities = Arrays.stream( user.getRoles().split( "," ) )
                                                   .map( SimpleGrantedAuthority::new )
                                                   .collect( Collectors.toList() );

        //        return new MyUserDetails( user.getUserName(), user.getPassword(), user.isActive(), authorities );
        return new org.springframework.security.core.userdetails.User( user.getUserName(), user.getPassword(), authorities );

    }

}
