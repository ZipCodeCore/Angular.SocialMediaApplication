package com.zcwtc.socialmedia.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    public User() {

    }

    public User(String username) {
        this.username = username;
    }

    public User(Long id, String username) {
        this(username);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void update(User user) {
        if(user.getUsername() != null) {
            this.username = user.getUsername();
        }
    }
}
