package com.zcwtc.socialmedia.Post;

import com.zcwtc.socialmedia.User.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {
    @GeneratedValue
    @Id
    private Long id;

    @Basic
    @Column(name = "CreatedTime", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;

    @Basic
    @Column(name = "LastTouched")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;

    @ManyToOne
    private User user;

    private String content;

    public Post() {

    }

    public Post(User user, Date createdTime, Date updatedTime, String content) {
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.user = user;
        this.content = content;
    }

    public Post(Long id, User user, Date createdTime, Date updatedTime, String content) {
        this(user, createdTime, updatedTime, content);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public void update(Post post) {
        if(post.getContent() != null) {
            this.content = post.getContent();
        }
    }

    @PrePersist
    public void createdAt() {
        this.createdTime = this.updatedTime = new Date();
    }


    @PreUpdate
    public void updatedAt() {
        this.updatedTime = new Date();
    }
}
