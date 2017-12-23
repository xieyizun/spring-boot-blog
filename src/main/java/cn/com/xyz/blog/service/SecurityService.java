package cn.com.xyz.blog.service;

/**
 * @projectName: SpringBootBlog
 * @packageName: cn.com.xyz.blog.service
 * @author: gzxieyizun
 * @date: 2017/12/23
 * @description:
 */
public interface SecurityService {
    public String findLoggedInUserEmail();
    public void autoLogin(String email, String password);
}
