package za.ac.cput.factory;

import za.ac.cput.domain.Appointment;
import za.ac.cput.util.Helper;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class AppointmentFactory {
    public static Appointment buildAppointment(String appointment_Id, String client_phoneNumber, String service_id, String barber_id, LocalDate appointment_date, LocalTime appointment_time){
        if(Helper.isNullOrEmpty(appointment_Id) || Helper.isNullOrEmpty(client_phoneNumber) || Helper.isNullOrEmpty(service_id) || Helper.isNullOrEmpty(barber_id) || !Helper.dateIsValid(appointment_date) || !Helper.timeIsValid(appointment_time))
            return null;

        return new Appointment.Builder().setAppointment_Id(appointment_Id)
                .setClient_phoneNumber(client_phoneNumber)
                .setService_id(service_id)
                .setBarber_id(barber_id)
                .setAppointment_date(appointment_date)
                .setAppointment_time(appointment_time)
                .build();
    }

    public static Appointment buildAppointment(String client_phoneNumber, String service_id, String barber_id, LocalDate appointment_date, LocalTime appointment_time){
        if(Helper.isNullOrEmpty(client_phoneNumber) || Helper.isNullOrEmpty(service_id) || Helper.isNullOrEmpty(barber_id) || !Helper.dateIsValid(appointment_date) || !Helper.timeIsValid(appointment_time))
            return null;
        String appointment_Id = Helper.generateId();

        return new Appointment.Builder().setAppointment_Id(appointment_Id)
                .setClient_phoneNumber(client_phoneNumber)
                .setService_id(service_id)
                .setBarber_id(barber_id)
                .setAppointment_date(appointment_date)
                .setAppointment_time(appointment_time)
                .build();
    }
}
