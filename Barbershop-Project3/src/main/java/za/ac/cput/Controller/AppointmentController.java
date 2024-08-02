package za.ac.cput.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.cput.factory.AppointmentFactory;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
    @GetMapping
    String getAppointment(Model model) {
        model.addAttribute("heading","Appointments");
        model.addAttribute("appointment", Arrays.asList(
                AppointmentFactory.buildAppointment("001","012 345 6789","01","100", LocalDate.of(2024,12,1), LocalTime.of(8,00)),
                AppointmentFactory.buildAppointment("002","012 345 9876","02","101", LocalDate.of(2024,12,1), LocalTime.of(9,00)),
                AppointmentFactory.buildAppointment("003","012 345 8967","03","102", LocalDate.of(2024,12,2), LocalTime.of(8,00)),
                AppointmentFactory.buildAppointment("004","012 345 7687","02","101", LocalDate.of(2024,12,2), LocalTime.of(9,00))
        ));
        return "appointment";
    }
}