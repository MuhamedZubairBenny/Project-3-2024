package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Admin;
import za.ac.cput.factory.AdminFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class AdminServiceTest {
    @Autowired
    private AdminService adminService;

    private static Admin admin1;
    private static Admin admin2;

    @Test
    void a_setup() {
        admin1 = AdminFactory.buildAdmin("001", "Zubair", "123");
        assertNotNull(admin1);
        admin2 = AdminFactory.buildAdmin("002", "Duane", "456");
        assertNotNull(admin2);
    }
    @Test
    void b_create() {
        Admin created1 = adminService.create(admin1);
        assertNotNull(created1);
        System.out.println(created1);
        Admin created2 = adminService.create(admin2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void c_read() {
        Admin read = adminService.read(admin1.getAdminId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Admin newAdmin = new Admin.Builder().copy(admin1).setUsername("Muhamed Zubair").build();
        Admin updatedAdmin = adminService.update(newAdmin);
        assertNotNull(updatedAdmin);
        System.out.println(updatedAdmin);
    }

    @Test
    @Disabled
    void e_delete() {
        adminService.delete(admin2.getAdminId());
        System.out.println("Successfully deleted Admin");
    }

    @Test
    void f_getAll() {
        System.out.println(adminService.getAll());
    }
}