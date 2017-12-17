package cn.com.xyz.blog.entity;

import cn.com.xyz.blog.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="comments")
public class Comment extends BaseEntity {
    private User user;
    private Article article;
    private String content;

    public Comment() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Column(name="content", columnDefinition = "TEXT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
