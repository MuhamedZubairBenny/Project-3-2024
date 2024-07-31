package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Appointment {
    @Id
    public String appointment_Id;
    public String client_phoneNumber;
    public String service_id;
    public String barber_id;
    private LocalDate appointment_date;
    private LocalTime appointment_time;

    protected Appointment() {}

    public Appointment(Builder builder){
        this.appointment_Id = builder.appointment_Id;
        this.client_phoneNumber = builder.client_phoneNumber;
        this.service_id = builder.service_id;
        this. barber_id = builder.barber_id;
        this.appointment_date = builder.appointment_date;
        this.appointment_time = builder.appointment_time;
    }

    public String getAppointment_Id() {
        return appointment_Id;
    }

    public String getClient_phoneNumber() {
        return client_phoneNumber;
    }

    public String getService_id() {
        return service_id;
    }

    public String getBarber_id() {
        return barber_id;
    }

    public LocalDate getAppointment_date() {
        return appointment_date;
    }

    public LocalTime getAppointment_time() {
        return appointment_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return client_phoneNumber == that.client_phoneNumber && Objects.equals(appointment_Id, that.appointment_Id) && Objects.equals(service_id, that.service_id) && Objects.equals(barber_id, that.barber_id) && Objects.equals(appointment_date, that.appointment_date) && Objects.equals(appointment_time, that.appointment_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointment_Id, client_phoneNumber, service_id, barber_id, appointment_date, appointment_time);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointment_Id='" + appointment_Id + '\'' +
                ", client_phoneNumber=" + client_phoneNumber +
                ", service_id='" + service_id + '\'' +
                ", barber_id='" + barber_id + '\'' +
                ", appointment_date=" + appointment_date +
                ", appointment_time=" + appointment_time +
                '}';
    }

    public static class Builder{
        private String appointment_Id;
        private String client_phoneNumber;
        private String service_id;
        private String barber_id;
        private LocalDate appointment_date;
        private LocalTime appointment_time;

        public Builder setAppointment_Id(String appointment_Id) {
            this.appointment_Id = appointment_Id;
            return this;
        }

        public Builder setClient_phoneNumber(String client_phoneNumber) {
            this.client_phoneNumber = client_phoneNumber;
            return this;
        }

        public Builder setService_id(String service_id) {
            this.service_id = service_id;
            return this;
        }

        public Builder setBarber_id(String barber_id) {
            this.barber_id = barber_id;
            return this;
        }

        public Builder setAppointment_date(LocalDate appointment_date) {
            this.appointment_date = appointment_date;
            return this;
        }

        public Builder setAppointment_time(LocalTime appointment_time) {
            this.appointment_time = appointment_time;
            return this;
        }

        public Builder copy(Appointment appointment){
            this.appointment_Id = appointment.appointment_Id;
            this.client_phoneNumber = appointment.client_phoneNumber;
            this.service_id = appointment.service_id;
            this. barber_id = appointment.barber_id;
            this.appointment_date = appointment.appointment_date;
            this.appointment_time = appointment.appointment_time;
            return this;
        }

        public Appointment build(){return new Appointment(this);}
    }
}
