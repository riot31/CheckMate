package com.springapp.mvc.service;

import com.springapp.mvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by o.lutsevich on 2.2.16.
 */
@Service("loginService")
public class LoginService implements UserDetailsService {
    private static final String DEFAULT_ROLE = "ROLE_USER";
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        return buildUserForAuthentication(user, buildUserAuthority());
    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority() {
        Set<GrantedAuthority> authoritySet = new HashSet<GrantedAuthority>();
        authoritySet.add(new SimpleGrantedAuthority(DEFAULT_ROLE));
        return new ArrayList<GrantedAuthority>(authoritySet);
    }
}
