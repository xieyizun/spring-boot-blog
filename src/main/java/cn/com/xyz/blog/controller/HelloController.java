package cn.com.xyz.blog.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: SpringBootBlog
 * @packageName: cn.com.xyz.SpringBootBlog.controller
 * @author: gzxieyizun
 * @date: 2017/12/10
 * @description:
 */

@RestController
public class HelloController {
    @RequestMapping(value="/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> index() {
        Map<String, Object> res = new HashMap<>();
        res.put("data", "Hi man, welcome to xieyizun's blog");
        return res;
    }
}
