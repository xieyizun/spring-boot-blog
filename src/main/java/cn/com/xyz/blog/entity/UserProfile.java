package cn.com.xyz.blog.entity;

import cn.com.xyz.blog.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @projectName: SpringBootBlog
 * @packageName: cn.com.xyz.blog.domain
 * @author: gzxieyizun
 * @date: 2017/12/16
 * @description:
 */
@Entity
@Table(name="user_profiles")
public class UserProfile extends BaseEntity {
    private String phone;
    private String school;
    private String company;
    private String description;

    private User user;

    public UserProfile() {
    }

    @Column(name="phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name="school")
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Column(name="company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    public User getUser () {
        return  user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
