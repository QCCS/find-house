package com.findhouse.service.user;


import com.findhouse.entity.Role;
import com.findhouse.entity.User;
import com.findhouse.repository.RoleRepository;
import com.findhouse.repository.UserRepository;
import com.findhouse.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    private RoleRepository roleRepository;

    @Override
    public User findUserByName(String userName) {
        System.out.println(userName);
        System.out.println(1);
        User user = userRepository.findByName(userName);
        return user;

//        System.out.println(user);
//        System.out.println(user.getId());
//        if (user == null) {
//            return null;
//        }
//
//        List<Role> roles = roleRepository.findRolesByUserId(user.getId());
//
//        System.out.println(roles);
//        if (roles == null || roles.isEmpty()) {
//            throw new DisabledException("权限非法");
//        }
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName())));
//        user.setAuthorityList(authorities);
//        return user;
    }



}
