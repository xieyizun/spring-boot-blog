package cn.com.xyz.blog.config;

import cn.com.xyz.blog.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.springframework.http.HttpMethod.PATCH;

/**
 * @projectName: SpringBootBlog
 * @packageName: cn.com.xyz.blog.config
 * @author: gzxieyizun
 * @date: 2017/12/23
 * @description:
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    private static final String[] WILDCARD_PATTERN = { "/**" };


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll()
            .anyRequest().authenticated();
//
//        http.httpBasic().disable().authorizeRequests()
//                .antMatchers("/", "/users/registration").permitAll()
//                .antMatchers().authenticated()
//                // the last one needs a URL, else throws exception
//                // Caused by: java.lang.IllegalStateException: An incomplete mapping was found for []. Try completing it with something like requestUrls().<something>.hasRole('USER')
//                .antMatchers(PATCH, WILDCARD_PATTERN).permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(bCryptPasswordEncoder());
    }
}
