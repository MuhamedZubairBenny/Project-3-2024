package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Barber;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BarberFactoryTest {
    private static Barber barber1;
    private static Barber barber2;

    @Test
    @Order(1)
    void buildBarber() {
        barber1 = BarberFactory.buildBarber("001","Ben", "Zubair", "ben10","beard", "1234");
        assertNotNull(barber1);
        System.out.println(barber1);
    }

    @Test
    @Order(2)
    void testBuildBarber() {
        barber2 = BarberFactory.buildBarber("prince", "duane", "darock","fade", "5678");
        assertNotNull(barber2);
        System.out.println(barber2);
    }

    @Test
    @Order(3)
    void testWithFail() {
        barber2 = BarberFactory.buildBarber("","prince", "duane", "darock","fade", "5678");
        assertNotNull(barber2);
        System.out.println(barber2);
    }
}