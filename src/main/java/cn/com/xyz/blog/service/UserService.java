package cn.com.xyz.blog.service;

import cn.com.xyz.blog.entity.User;

/**
 * @projectName: SpringBootBlog
 * @packageName: cn.com.xyz.blog.service
 * @author: gzxieyizun
 * @date: 2017/12/23
 * @description:
 */
public interface UserService {
    public void save(User user);
    public User findByUserEmail(String email);
}
