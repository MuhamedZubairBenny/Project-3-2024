package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Admin;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminFactoryTest {

    @Test
    @Order(1)
    void buildAdmin() {
        //Build Admin
        Admin admin = new AdminFactory().buildAdmin("100", "Reanu Keeves", "123");
        assertNotNull(admin);
        System.out.println(admin);
    }

    @Test
    @Order(2)
    void buildAdminWithNoAdminId() {
        //Build Admin without Id
        Admin admin = new AdminFactory().buildAdmin("Zubair", "456");
        assertNotNull(admin);
        System.out.println(admin);
    }

    @Test
    @Order(3)
    void buildWithFail(){
        Admin admin = new AdminFactory().buildAdmin("", "Duane", "789");
        assertNotNull(admin);
        System.out.println(admin);
    }
}