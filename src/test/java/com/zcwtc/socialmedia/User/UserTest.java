package com.zcwtc.socialmedia.User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User user1;
    private User user2;
    private User user3;

    private String username;

    @Before
    public void setUp() {
        username = "domi";

        user1 = new User();
        user2 = new User(username);
        user3 = new User(3L, username);
    }

    @Test
    public void instantiation() {
        Assert.assertNotNull(user1);
        Assert.assertNotNull(user2);
        Assert.assertNotNull(user3);
    }

    @Test
    public void getId() {
        Long expected = 3L;
        Long actual = user3.getId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setId() {
        user1.setId(1L);

        Long expected = 1L;
        Long actual = user1.getId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getUsername() {
        Assert.assertEquals(username, user2.getUsername());
        Assert.assertEquals(username, user2.getUsername());
    }

    @Test
    public void setUsername() {
        user1.setUsername(username);

        Assert.assertEquals(username, user1.getUsername());

    }

    @Test
    public void update() {
        user1.update(user3);

        Assert.assertEquals(user1.getUsername(), user3.getUsername());
        Assert.assertNotEquals(user1.getId(), user3.getId());
    }
}
