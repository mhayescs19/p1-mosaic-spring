package com.example.project.Security.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserDao userDaoService;
    @Autowired
    public UserService(@Qualifier("DynamoDb") UserDao userDaoService) {
        this.userDaoService = userDaoService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDaoService.selectUserByUsername(username).orElseThrow(()-> new UsernameNotFoundException("username of "+username+" not found"));

    }
}
