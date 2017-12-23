package cn.com.xyz.blog.controller;

import cn.com.xyz.blog.entity.User;
import cn.com.xyz.blog.service.SecurityService;
import cn.com.xyz.blog.service.UserService;
import cn.com.xyz.blog.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: SpringBootBlog
 * @packageName: cn.com.xyz.blog.controller
 * @author: gzxieyizun
 * @date: 2017/12/16
 * @description:
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;

    @PostMapping("/registration")
    public Map<String, Object> register(@RequestBody User user, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<>();

        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            result.put("status", 0);
            return result;
        }

        userService.save(user);
        // auto login
        securityService.autoLogin(user.getEmail(), user.getPassword());
        result.put("status", 1);
        return result;
    }
}
