package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Login;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LoginFactoryTest {

    @Test
    @Order(1)
    void buildLoginWithValidInputs() {
        Login login = LoginFactory.createLogin("user123", "password123");
        assertNotNull(login, "Login should not be null");
        assertEquals("user123", login.getUsername(), "Username should match");
        assertEquals("password123", login.getPassword(), "Password should match");
        System.out.println(login);
    }

    @Test
    @Order(2)
    void buildLoginWithEmptyUsername() {
        Login login = LoginFactory.createLogin("", "password456");
        assertNotNull(login, "Login should not be null");
        assertEquals("", login.getUsername(), "Username should be empty");
        assertEquals("password456", login.getPassword(), "Password should match");
        System.out.println(login);
    }

    @Test
    @Order(3)
    void buildLoginWithInvalidPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Login login = LoginFactory.createLogin("user789", null); // Assuming null password should fail
        });
        assertEquals("Password cannot be null", exception.getMessage());
        System.out.println("Expected exception caught: " + exception.getMessage());
    }
}

