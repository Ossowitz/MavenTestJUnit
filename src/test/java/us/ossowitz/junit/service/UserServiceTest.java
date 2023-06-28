package us.ossowitz.junit.service;

import org.junit.jupiter.api.Test;
import us.ossowitz.junit.dto.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    void usersEmptyIfNoUserAdded() {
        UserService userService = new UserService();
        List<User> users = userService.getAll();
        assertTrue(users.isEmpty());
    }
}
