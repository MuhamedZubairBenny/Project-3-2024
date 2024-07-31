package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Appointment;
import za.ac.cput.factory.AppointmentFactory;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class AppointmentServiceTest {
    @Autowired
    private AppointmentService appointmentService;

    private static Appointment appointment1;
    private static Appointment appointment2;

    LocalDate date1 = LocalDate.of(2024, 7, 31);
    LocalTime time1 = LocalTime.of(13, 00);
    LocalDate date2 = LocalDate.of(2024, 8, 1);
    LocalTime time2 = LocalTime.of(14, 00);

    @Test
    void a_setup() {
        appointment1 = AppointmentFactory.buildAppointment("001", "012 345 6789", "100", "01", LocalDate.of(2024,7,31), LocalTime.of(13,00));
        appointment2 = AppointmentFactory.buildAppointment("002", "012 456 7890", "100", "02", date2, time2);
    }
    @Test
    void b_create() {
        Appointment created1 = appointmentService.create(appointment1);
        assertNotNull(created1);
        System.out.println(created1);
        Appointment created2 = appointmentService.create(appointment2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void c_read() {
        Appointment read = appointmentService.read(appointment1.getAppointment_Id());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Appointment newAppointment = new Appointment.Builder().copy(appointment1).setAppointment_date(LocalDate.of(2024,12,12)).build();
        Appointment updatedAppointment = appointmentService.update(newAppointment);
        assertNotNull(updatedAppointment);
        System.out.println(updatedAppointment);
    }

    @Test
    void e_delete() {
        appointmentService.delete(appointment2.getAppointment_Id());
        System.out.println("Successfully deleted Appointment");
    }

    @Test
    void f_getAll() {
        System.out.println(appointmentService.getAll());
    }
}
