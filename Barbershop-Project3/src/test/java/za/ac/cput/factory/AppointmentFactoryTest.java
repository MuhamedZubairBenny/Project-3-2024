package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AppointmentFactoryTest {

    @Test
    @Order(1)
    void buildAppointment() {
        LocalDate date = LocalDate.of(2024, 7, 31);
        LocalTime time = LocalTime.of(14, 00);
        Appointment appointment = AppointmentFactory.buildAppointment("001", "012 345 6789", "100", "01", date, time);
        assertNotNull(appointment);
        System.out.println(appointment);
    }

    @Test
    @Order(2)
    void testBuildAppointment() {
        LocalDate date = LocalDate.of(2024, 8, 1);
        LocalTime time = LocalTime.of(12, 00);
        Appointment appointment = AppointmentFactory.buildAppointment("987 654 3210", "101", "02", date, time);
        assertNotNull(appointment);
        System.out.println(appointment);
    }

    @Test
    @Order(3)
    void buildAppointmentWithFail() {
        LocalDate date = LocalDate.of(2024, 8, 1);
        LocalTime time = LocalTime.of(12, 00);
        Appointment appointment = AppointmentFactory.buildAppointment("","987 654 3210", "101", "02", date, time);
        assertNotNull(appointment);
        System.out.println(appointment);
    }
}