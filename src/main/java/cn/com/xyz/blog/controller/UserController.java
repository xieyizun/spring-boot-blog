package cn.com.xyz.blog.controller;

import cn.com.xyz.blog.entity.User;
import cn.com.xyz.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: SpringBootBlog
 * @packageName: cn.com.xyz.blog.controller
 * @author: gzxieyizun
 * @date: 2017/12/16
 * @description:
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public String register() {
        User user = new User();
        user.setName("xieyizun");
        user.setEmail("gzxieyizun");
        user.setPassword("123456");
        userRepository.save(user);

        return "register successfully";
    }
}
