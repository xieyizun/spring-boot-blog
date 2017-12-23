package cn.com.xyz.blog.entity;

import cn.com.xyz.blog.base.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

/**
 * @projectName: SpringBootBlog
 * @packageName: cn.com.xyz.blog.domain
 * @author: gzxieyizun
 * @date: 2017/12/16
 * @description:
 */
@Entity
@Table(name="users")
public class User extends BaseEntity {
    private String name;
    private String email;
    private String password;
    private Boolean isActived;
    private Set<Role> roles;


    private UserProfile userProfile;
    private List<Category> categories;
    private List<Article> articles;
    private List<Comment> comments;

    public User() {
    }

    @Column(name="name", nullable = false)
    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="actived", columnDefinition = "tinyint(1) default 1")
    public Boolean getActived() {
        return isActived;
    }

    public void setActived(Boolean actived) {
        isActived = actived;
    }

    @ManyToMany
    @JoinTable(name="users_roles",
               joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
              fetch = FetchType.LAZY, optional = false)
    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,
                orphanRemoval = true)
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,
                orphanRemoval = true)
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,
                orphanRemoval = true)
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}

