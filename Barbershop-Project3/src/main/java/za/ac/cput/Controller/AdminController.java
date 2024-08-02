package za.ac.cput.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.cput.domain.Admin;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.repository.AdminRepository;
import za.ac.cput.service.AdminService;

import java.util.Arrays;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    String getAdmin(Model model) {
        model.addAttribute("heading","Admin List");
        model.addAttribute("admin", Arrays.asList(
                AdminFactory.buildAdmin("01","Zubair","123"),
                AdminFactory.buildAdmin("02","Duane","456"),
                AdminFactory.buildAdmin("03","Isa","789")
        ));
        return "admin";
    }
}
