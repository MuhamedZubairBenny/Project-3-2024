package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Login;
import za.ac.cput.factory.LoginFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LoginServiceTest {

    @Autowired
    private LoginService loginService;

    private static Login login1;
    private static Login login2;

    @Test
    @Order(1)
    void a_setup() {
        login1 = LoginFactory.createLogin("user123", "password123");
        login2 = LoginFactory.createLogin("user456", "password456");
    }

    @Test
    @Order(2)
    void b_create() {
        Login created1 = loginService.create(login1);
        assertNotNull(created1, "Created login should not be null");
        assertEquals(login1.getUsername(), created1.getUsername(), "Username should match");
        assertEquals(login1.getPassword(), created1.getPassword(), "Password should match");
        System.out.println(created1);

        Login created2 = loginService.create(login2);
        assertNotNull(created2, "Created login should not be null");
        assertEquals(login2.getUsername(), created2.getUsername(), "Username should match");
        assertEquals(login2.getPassword(), created2.getPassword(), "Password should match");
        System.out.println(created2);
    }

    @Test
    @Order(3)
    void c_read() {
        Login read = loginService.read(login1.getUsername());
        assertNotNull(read, "Read login should not be null");
        assertEquals(login1.getUsername(), read.getUsername(), "Username should match");
        System.out.println(read);
    }

    @Test
    @Order(4)
    void d_update() {
        Login updatedLogin = new Login.Builder()
                .copy(login1)
                .setPassword("newpassword123")
                .build();
        Login updated = loginService.update(updatedLogin);
        assertNotNull(updated, "Updated login should not be null");
        assertEquals("newpassword123", updated.getPassword(), "Password should be updated");
        System.out.println(updated);
    }

    @Test
    @Order(5)
    @Disabled
    void e_delete() {
        loginService.create(login2);
        loginService.delete(login2.getUsername());
        Login deleted = loginService.read(login2.getUsername());
        assertNull(deleted, "Deleted login should be null");
        System.out.println("Successfully deleted login");
    }

    @Test
    @Order(6)
    void f_loginExists() {
        boolean exists = loginService.loginExists(login1.getUsername());
        assertTrue(exists, "Login should exist");

        boolean doesNotExist = loginService.loginExists("nonexistentuser");
        assertFalse(doesNotExist, "Login should not exist");
    }
}


