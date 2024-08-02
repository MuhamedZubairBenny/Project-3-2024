package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.cput.domain.Barber;
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
    @PostMapping("/saveBarber")
    public String addBarber(@RequestParam String username, @RequestParam String password, @RequestParam String name, @RequestParam String specialization, @RequestParam String number){
        Barber barber = BarberFactory.buildBarber(username, password, name, specialization, number);
        service.update(barber);
        System.out.println("Updated: "+barber);
        return  "redirect:/barbers";
    }

    @PostMapping("/updateBarber")
    public String updateBarber(@RequestParam String username, @RequestParam String password, @RequestParam String name, @RequestParam String specialization, @RequestParam String number){
        Barber barber = BarberFactory.buildBarber(username, password, name, specialization, number);
        service.update(barber);
        System.out.println("Updated: "+barber);
        return  "redirect:/barbers";
    }

    @PostMapping("/deleteBarber")
    public String deleteBarber(@RequestParam String id){
        service.delete(id);
        return "redirect:/barbers";
    }


}
