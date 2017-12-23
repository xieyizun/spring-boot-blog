package cn.com.xyz.blog.service.impl;

import cn.com.xyz.blog.entity.Role;
import cn.com.xyz.blog.entity.User;
import cn.com.xyz.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * @projectName: SpringBootBlog
 * @packageName: cn.com.xyz.blog.service.impl
 * @author: gzxieyizun
 * @date: 2017/12/23
 * @description: spring security
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            for (Role role : user.getRoles()) {
                grantedAuthorities.add(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return role.getName();
                    }
                });
            }
            return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), grantedAuthorities);
        }
        return null;
    }
}
