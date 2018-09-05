package com.zcwtc.socialmedia.Post;

import com.zcwtc.socialmedia.User.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class PostTest {
    private String content;
    private User user;
    private Date createdTime;
    private Date updatedTime;

    private Post post1;
    private Post post2;
    private Post post3;

    @Before
    public void setUp() {
        createdTime = new Date();
        updatedTime = new Date();
        content = "new post";
        user = new User();

        post1 = new Post();
        post2 = new Post(user, createdTime, updatedTime, content);
        post3 = new Post(3L, user, createdTime, updatedTime, content);
    }

    @Test
    public void instantiation() {
        Assert.assertNotNull(post1);
        Assert.assertNotNull(post2);
        Assert.assertNotNull(post3);
    }

    @Test
    public void getId() {
        Long expected = 3L;
        Long actual = post3.getId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setId() {
        post1.setId(1L);

        Long expected = 1L;
        Long actual = post1.getId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getUser() {
        Assert.assertEquals(user, post2.getUser());
        Assert.assertEquals(user, post3.getUser());
    }

    @Test
    public void setUser() {
        post1.setUser(user);

        Assert.assertEquals(user, post1.getUser());
    }

    @Test
    public void getContent() {
        Assert.assertEquals(content, post2.getContent());
        Assert.assertEquals(content, post3.getContent());
    }

    @Test
    public void setCreatedTime() {
        post1.setCreatedTime(createdTime);

        Assert.assertEquals(createdTime, post1.getCreatedTime());
    }

    @Test
    public void update() {
        post1.update(post3);

        Assert.assertEquals(post1.getContent(), post3.getContent());
        Assert.assertNotEquals(post1.getId(), post3.getId());
    }
}
