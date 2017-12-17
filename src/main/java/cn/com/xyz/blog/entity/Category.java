package cn.com.xyz.blog.entity;

import cn.com.xyz.blog.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @projectName: SpringBootBlog
 * @packageName: cn.com.xyz.blog.domain
 * @author: gzxieyizun
 * @date: 2017/12/16
 * @description:
 */
@Entity
@Table(name="categories")
@SequenceGenerator(name="seq", initialValue = 1, allocationSize = 100)
public class Category extends BaseEntity {
    private User user;
    private String name;
    private Integer position;

    public Category() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "position")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
