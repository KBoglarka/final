package com.epam.training.ticketservice.core.user.model;

import com.epam.training.ticketservice.core.movie.model.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private static final Room a10 = new Room("A10",10,10);
    private static final Room a07 = new Room("A07",5,8);

    private static final User me = new User("Me", "hello", User.Role.USER);
    private static final User admin = new User("admin", "admin", User.Role.ADMIN);
    private static final User user = new User("user", "nono", User.Role.USER);

    @Test
    void getId() {

    }

    @Test
    void getUsername() {
        assertTrue(me.getUsername().equals("Me"));
        assertFalse(admin.getUsername().equals("user"));
    }

    @Test
    void getPassword() {
        assertTrue(me.getPassword().equals("hello"));
    }

    @Test
    void getRole() {
        assertTrue(me.getRole() == User.Role.USER);
        assertTrue(admin.getRole() == User.Role.ADMIN);
    }

    @Test
    void setId() {
    }

    @Test
    void setUsername() {
        user.setUsername("user2");
        assertEquals("user2", user.getUsername());
        user.setUsername("user");
    }

    @Test
    void setPassword() {
        user.setPassword("password");
        assertEquals("password", user.getPassword());
        user.setPassword("nono");
    }

    @Test
    void setRole() {
        user.setRole(User.Role.ADMIN);
        assertEquals(User.Role.ADMIN, user.getRole());
        user.setRole(User.Role.USER);
    }

    @Test
    void testEquals() {
        User copy = me;
        assertFalse(me.equals(admin));
        assertEquals(me, copy);
        assertTrue(me == me);
        assertFalse(me == null);
    }

    @Test
    void canEqual() {
        assertTrue(me.canEqual(me));
        assertFalse(me.canEqual(null));
    }

    @Test
    void testHashCode() {
        User copy = me;
        assertFalse(me.hashCode() == admin.hashCode());
        assertEquals(me.hashCode(), copy.hashCode());

    }

    @Test
    void testToString() {
        assertEquals("Me USER", me.toString());
    }
}