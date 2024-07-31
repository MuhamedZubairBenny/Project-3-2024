package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Appointment;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String> {
    //List <Appointment> findAllByAppointment_date(LocalDate date);
    //List<Appointment> findAllByAppointment_dateAndAppointment_time(LocalDate date, LocalTime time);
}
