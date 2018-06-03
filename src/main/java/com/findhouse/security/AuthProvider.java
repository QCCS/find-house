package com.findhouse.security;

import com.findhouse.entity.User;
import com.findhouse.service.IUserService;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 自定义认证实现
 */
public class AuthProvider implements AuthenticationProvider {
    @Autowired
    private IUserService userService;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String inputPassword = (String) authentication.getCredentials();
        System.out.println(userName);
        System.out.println(inputPassword);
        User user = userService.findUserByName(userName);
        if (user == null) {
            throw new AuthenticationCredentialsNotFoundException("authError");
        }
        System.out.println("-----");
        System.out.println(passwordEncoder.encode(inputPassword));
        System.out.println(inputPassword);
        System.out.println(user.getPassword());
        System.out.println("++++");
//        if (this.passwordEncoder.matches(user.getPassword(), inputPassword, user.getId())) {
//            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//        }

        throw new BadCredentialsException("authError");

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
