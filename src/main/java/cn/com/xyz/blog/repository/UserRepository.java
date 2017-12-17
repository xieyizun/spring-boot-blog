package cn.com.xyz.blog.repository;

import cn.com.xyz.blog.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @projectName: SpringBootBlog
 * @packageName: cn.com.xyz.blog.repository
 * @author: gzxieyizun
 * @date: 2017/12/16
 * @description:
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
