package com.findhouse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by zhouli on 18/6/2
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //spring boot2加入Security依赖之后，禁用Security
        http.csrf().disable().authorizeRequests().anyRequest().permitAll();
    }
}