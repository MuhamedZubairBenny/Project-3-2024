package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import za.ac.cput.service.BarberServiceImpl;

@Controller
public class BarberController {
    @Autowired
    private BarberServiceImpl service;
    //^For when we start using db connectivity

    @GetMapping("/Barbers")
    public String showBarbers(){
        return "barber";
    }
}
