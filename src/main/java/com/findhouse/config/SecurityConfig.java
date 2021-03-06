package com.findhouse.config;

import com.findhouse.security.AuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by zhouli on 18/6/2
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //spring boot2加入Security依赖之后，禁用Security
        http.csrf().disable().authorizeRequests().anyRequest().permitAll();


        // 资源访问权限
//        http.authorizeRequests()
//                .antMatchers("/admin/login").permitAll() // 管理员登录入口
//                .antMatchers("/static/**").permitAll() // 静态资源
//                .antMatchers("/user/login").permitAll() // 用户登录入口
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
//                .antMatchers("/api/user/**").hasAnyRole("ADMIN", "USER")
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/login") // 配置角色登录处理入口
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/logout/page")
//                .deleteCookies("JSESSIONID")
//                .invalidateHttpSession(true)
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/403");
//
//        http.csrf().disable();
//        //同源策略
//        http.headers().frameOptions().sameOrigin();

    }
    /**
     * 自定义认证策略
     */
    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //把用户与密码写在内存中，方便测试
//        auth.inMemoryAuthentication().withUser("admin").password("admin")
//        .roles("ADMIN").and();
        auth.authenticationProvider(authProvider()).eraseCredentials(true);
    }
    @Bean
    public AuthProvider authProvider() {
        return new AuthProvider();
    }


}