package us.ossowitz.junit.service;

import org.junit.jupiter.api.*;
import us.ossowitz.junit.dto.User;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {
    private UserService userService;

    @BeforeAll
    public void init() {
        System.out.println("Before all: " + this);
    }

    @BeforeEach
    public void prepare() {
        System.out.println("Before each: " + this);
        userService = new UserService();
    }

    @Test
    public void usersEmptyIfNoUserAdded() {
        System.out.println("Test 1: " + this);
        var users = userService.getAll();
        assertTrue(users.isEmpty(), () -> "User list should be empty");
    }

    @Test
    public void usersSizeIfUserAdded() {
        System.out.println("Test 2: " + this);

        userService.add(new User());
        userService.add(new User());

        var users = userService.getAll();
        assertEquals(2, users.size());
    }

    @AfterEach
    public void deleteDataFromDatabase() {
        System.out.println("After each: " + this);
    }

    @AfterAll
    public void closeConnectionPool() {
        System.out.println("After all: " + this);
    }
}
