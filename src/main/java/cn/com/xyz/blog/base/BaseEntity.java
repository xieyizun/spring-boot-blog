package cn.com.xyz.blog.base;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

/**
 * @projectName: SpringBootBlog
 * @packageName: cn.com.xyz.blog.base
 * @author: gzxieyizun
 * @date: 2017/12/16
 * @description:
 */

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    private Long id;
    private Boolean enable;

    private Long createdBy;
    private Date createdTime;
    private Long updatedBy;
    private Date updatedTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="enabled")
    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @Column(name="created_by")
    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="created_time")
    public Date getCreatedTime() {
        return createdTime;
    }

    // @PrePersist
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime==null ? new Date() : createdTime;
    }

    @Column(name="updated_by")
    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Column(name="updated_time")
    public Date getUpdatedTime() {
        return updatedTime;
    }

    // @PreUpdate
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime == null ? new Date() : updatedTime;
    }

}
