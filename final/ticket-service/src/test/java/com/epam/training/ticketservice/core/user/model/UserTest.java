package com.epam.training.ticketservice.core.user.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private static final User me = new User("Me", "hello", User.Role.USER);
    private static final User admin = new User("admin", "admin", User.Role.ADMIN);
    private static final User user = new User("user", "nono", User.Role.USER);
    private static final User SET = new User("user", "nono", User.Role.USER);

    @Test
    void testToString() {
        assertEquals(admin.toString(), "Signed in with privileged account admin");
    }

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
        SET.setUsername("user2");
        assertEquals("user2", SET.getUsername());
    }

    @Test
    void setPassword() {
        SET.setPassword("password");
        assertEquals("password", SET.getPassword());
    }

    @Test
    void setRole() {
        SET.setRole(User.Role.ADMIN);
        assertEquals(User.Role.ADMIN, SET.getRole());
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
}