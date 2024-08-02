package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import za.ac.cput.factory.BarberFactory;
import za.ac.cput.service.BarberServiceImpl;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Controller
public class BarberController {
    @Autowired
    private BarberServiceImpl service;
    //^For when we start using db connectivity

    @GetMapping("/barbers")
    public String showBarbers(Model model){
        model.addAttribute("staff", "Staff");
        model.addAttribute("barbers", Arrays.asList(
                BarberFactory.buildBarber("001","Ben", "Zubair", "ben10","beard", "081345678"),
                BarberFactory.buildBarber("002","prince", "Duane", "darock","fade", "0213457689")
        ));
        return "barbers";
    }


}
