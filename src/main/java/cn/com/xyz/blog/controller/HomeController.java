package cn.com.xyz.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @projectName: SpringBootBlog
 * @packageName: cn.com.xyz.blog.controller
 * @author: gzxieyizun
 * @date: 2017/12/10
 * @description:
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "frontend/dist/index.html";
    }
}
