package cn.com.xyz.blog.service.impl;

import cn.com.xyz.blog.entity.Role;
import cn.com.xyz.blog.entity.User;
import cn.com.xyz.blog.repository.RoleRepository;
import cn.com.xyz.blog.repository.UserRepository;
import cn.com.xyz.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * @projectName: SpringBootBlog
 * @packageName: cn.com.xyz.blog.service.impl
 * @author: gzxieyizun
 * @date: 2017/12/23
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUserEmail(String email) {
        return null;
    }
}
