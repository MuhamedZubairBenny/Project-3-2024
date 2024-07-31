package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.factory.PaymentFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentServiceTest {
    @Autowired
    private PaymentService paymentService;

private static Payment payment1;
private static Payment payment2;

    @Test
    void a_setup() {
        LocalDate paymentDate1 = LocalDate.parse("2024-07-31");
        payment1= new PaymentFactory().buildPayment("A1","haircut and Trim",paymentDate1,150);
        assertNotNull(payment1);

        LocalDate paymentDate2 = LocalDate.parse("2024-08-05");
        payment2= new PaymentFactory().buildPayment("A2", "Trim",paymentDate2,90);
        assertNotNull(payment2);
    }

    @Test
    void b_create() {
        Payment created1 = paymentService.create(payment1);
        assertNotNull(created1);
        System.out.println(created1);
        Payment created2 = paymentService.create(payment2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void c_read() {
        Payment read = paymentService.read(payment1.getPaymentId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Payment newPayment = new Payment.Builder().copy(payment1).setPaymentAmount(120).build();
        Payment updatedPayment = paymentService.update(newPayment);
        assertNotNull(updatedPayment);
        System.out.println(updatedPayment);
    }

    @Test
    @Disabled
    void e_delete() {
        paymentService.delete(payment2.getPaymentId());
        System.out.println("Successfully deleted existing payment");
    }

    @Test
    void f_getAll() {
        System.out.println(paymentService.getAll());
    }
}