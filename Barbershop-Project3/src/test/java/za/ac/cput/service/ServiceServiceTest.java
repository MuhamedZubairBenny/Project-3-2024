package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Service;
import za.ac.cput.factory.ServiceFactory;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ServiceServiceTest {

    @Autowired
    private ServiceService serviceService;

    private static Service service1;
    private static Service service2;

    @Test
    @Order(1)
    void a_setup() {
        service1 = ServiceFactory.createService("001", "Cleaning", "Deep cleaning service", 99.99);
        service2 = ServiceFactory.createService("002", "Gardening", "Garden maintenance", 49.99);
    }

    @Test
    @Order(2)
    void b_create() {
        Service created1 = serviceService.create(service1);
        assertNotNull(created1, "Created service should not be null");
        assertEquals(service1.getServiceId(), created1.getServiceId(), "Service ID should match");
        assertEquals(service1.getServiceName(), created1.getServiceName(), "Service name should match");
        assertEquals(service1.getServiceDescription(), created1.getServiceDescription(), "Service description should match");
        assertEquals(service1.getServicePrice(), created1.getServicePrice(), 0.01, "Service price should match");
        System.out.println(created1);

        Service created2 = serviceService.create(service2);
        assertNotNull(created2, "Created service should not be null");
        assertEquals(service2.getServiceId(), created2.getServiceId(), "Service ID should match");
        assertEquals(service2.getServiceName(), created2.getServiceName(), "Service name should match");
        assertEquals(service2.getServiceDescription(), created2.getServiceDescription(), "Service description should match");
        assertEquals(service2.getServicePrice(), created2.getServicePrice(), 0.01, "Service price should match");
        System.out.println(created2);
    }

    @Test
    @Order(3)
    void c_read() {
        Service read = serviceService.read(service1.getServiceId());
        assertNotNull(read, "Read service should not be null");
        assertEquals(service1.getServiceId(), read.getServiceId(), "Service ID should match");
        System.out.println(read);
    }

    @Test
    @Order(4)
    void d_update() {
        Service updatedService = new Service.Builder()
                .copy(service1)
                .setServicePrice(109.99)
                .build();
        Service updated = serviceService.update(updatedService);
        assertNotNull(updated, "Updated service should not be null");
        assertEquals(109.99, updated.getServicePrice(), 0.01, "Service price should be updated");
        System.out.println(updated);
    }

    @Test
    @Order(5)
    @Disabled
    void e_delete() {
        serviceService.create(service2);
        serviceService.delete(service2.getServiceId());
        Service deleted = serviceService.read(service2.getServiceId());
        assertNull(deleted, "Deleted service should be null");
        System.out.println("Successfully deleted service");
    }

    //NUR MUST FIX @Test
    //@Order(6)
    //void f_getAll() {
    //    List<Service> services = serviceService.getAll();
    //    assertNotNull(services, "Services list should not be null");
    //    assertFalse(services.isEmpty(), "Services list should not be empty");
    //    services.forEach(System.out::println);
    //}
}


