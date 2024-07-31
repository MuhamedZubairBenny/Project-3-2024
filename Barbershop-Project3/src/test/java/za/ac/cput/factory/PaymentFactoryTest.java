package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Payment;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    @Test
    void buildPayment() {
        LocalDate paymentDate = LocalDate.parse("2024-07-31");

        Payment payment= new PaymentFactory().buildPayment("A1","haircut and Trim",paymentDate,150);
        assertNotNull(payment);
        System.out.println(payment);
    }

    @Test
    void testBuildPayment() {
        LocalDate paymentDate = LocalDate.parse("2024-07-31");

        Payment payment= new PaymentFactory().buildPayment("A1",paymentDate,150);
        assertNotNull(payment);
        System.out.println(payment);
    }
    @Test
    void testBuildPaymentFail() {
        //Testing with wrong date format
        LocalDate paymentDate = LocalDate.parse("2024/07-31");

        Payment payment= new PaymentFactory().buildPayment("A2","A1",paymentDate,150);
        assertNotNull(payment);
        System.out.println(payment);
    }
}