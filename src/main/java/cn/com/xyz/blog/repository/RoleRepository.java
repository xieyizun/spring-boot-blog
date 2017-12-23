package cn.com.xyz.blog.repository;

import cn.com.xyz.blog.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @projectName: SpringBootBlog
 * @packageName: cn.com.xyz.blog.repository
 * @author: gzxieyizun
 * @date: 2017/12/23
 * @description:
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
