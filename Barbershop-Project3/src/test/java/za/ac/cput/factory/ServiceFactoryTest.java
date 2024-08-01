package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Service;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ServiceFactoryTest {

    @Test
    @Order(1)
    void createServiceWithValidInputs() {
        Service service = ServiceFactory.createService("001", "Cleaning", "Deep cleaning service", 99.99);
        assertNotNull(service, "Service should not be null");
        assertEquals("001", service.getServiceId(), "Service ID should match");
        assertEquals("Cleaning", service.getServiceName(), "Service name should match");
        assertEquals("Deep cleaning service", service.getServiceDescription(), "Service description should match");
        assertEquals(99.99, service.getServicePrice(), 0.01, "Service price should match");
        System.out.println(service);
    }

    @Test
    @Order(2)
    void createServiceWithEmptyServiceId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Service service = ServiceFactory.createService("", "Cleaning", "Deep cleaning service", 99.99);
        });
        assertEquals("Service ID cannot be null or empty", exception.getMessage());
        System.out.println("Expected exception caught: " + exception.getMessage());
    }

    @Test
    @Order(3)
    void createServiceWithNegativePrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Service service = ServiceFactory.createService("001", "Cleaning", "Deep cleaning service", -10.00);
        });
        assertEquals("Service price cannot be negative", exception.getMessage());
        System.out.println("Expected exception caught: " + exception.getMessage());
    }
}

