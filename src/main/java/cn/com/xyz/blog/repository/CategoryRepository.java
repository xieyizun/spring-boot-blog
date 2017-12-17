package cn.com.xyz.blog.repository;

import cn.com.xyz.blog.entity.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * @projectName: SpringBootBlog
 * @packageName: cn.com.xyz.blog.repository
 * @author: gzxieyizun
 * @date: 2017/12/16
 * @description:
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
