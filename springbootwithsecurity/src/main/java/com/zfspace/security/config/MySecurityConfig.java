package com.zfspace.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        // 定制请求的授权规则
        http.authorizeRequests().mvcMatchers("/").permitAll()
                .mvcMatchers("/level1/**").hasRole("VIP1")
                .mvcMatchers("/level2/**").hasRole("VIP2")
                .mvcMatchers("/level3/**").hasRole("VIP3");

        // 开启自动配置的登录功能
        http.formLogin().usernameParameter("username").passwordParameter("pwd")
                .loginPage("/userlogin");

        // 开启自动配置的注销功能
        // 注销成功会回到首页
        http.logout().logoutSuccessUrl("/");

        // 开启记住我功能
        http.rememberMe().rememberMeParameter("remember");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("zhangsan").password("123456").roles("VIP1", "VIP2")
                .and()
                .withUser("lisi").password("123456").roles("VIP2", "VIP3")
                .and()
                .withUser("wanngwu").password("123456").roles("VIP1", "VIP3");
    }
}
