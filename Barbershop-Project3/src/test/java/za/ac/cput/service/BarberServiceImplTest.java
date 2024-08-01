package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Barber;
import za.ac.cput.factory.BarberFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class BarberServiceImplTest {

    @Autowired
    private BarberServiceImpl service;

    private static Barber barber1;
    private static Barber barber2;

    @Test
    void a_setup() {
        barber1 = BarberFactory.buildBarber("001","Ben", "Zubair", "ben10","beard", "1234");
        assertNotNull(barber1);
        barber2 = BarberFactory.buildBarber("002","prince", "duane", "darock","fade", "5678");
        assertNotNull(barber2);
    }
    @Test
    void b_create() {
        Barber created1 = service.create(barber1);
        assertNotNull(created1);
        System.out.println(created1);
        Barber created2 = service.create(barber2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void c_read() {
        Barber read = service.read(barber1.getId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Barber newBarber = new Barber.Builder().copy(barber1).setUsername("Muhamed Zubair").build();
        Barber updatedBarber = service.update(newBarber);
        assertNotNull(updatedBarber);
        System.out.println(updatedBarber);
    }

    @Test
    @Disabled
    void e_delete() {
        service.delete(barber2.getId());
        System.out.println("Successfully deleted Admin");
    }

    @Test
    void f_getAll() {
        System.out.println(service.getall());
    }
}
