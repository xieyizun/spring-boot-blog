package cn.com.xyz.blog.entity;

import cn.com.xyz.blog.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

/**
 * @projectName: SpringBootBlog
 * @packageName: cn.com.xyz.blog.entity
 * @author: gzxieyizun
 * @date: 2017/12/23
 * @description:
 */
@Entity
@Table(name="roles")
public class Role extends BaseEntity {
    private String name;
    private List<User> users;

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
