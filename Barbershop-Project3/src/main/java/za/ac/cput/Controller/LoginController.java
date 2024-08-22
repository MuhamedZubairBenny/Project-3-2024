package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.cput.domain.*;
import za.ac.cput.service.*;


@Controller
public class LoginController {

    @Autowired
    private ClientServiceImpl clientService;

    public static String systemName;

    @GetMapping("/login")
    public String getLoginForm(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping("/validateLogin")
    public String validateLogin(@RequestParam String username, @RequestParam String password, @RequestParam String userType, Model model) {
        boolean isValidLogin = clientService.validateLogin(username, password, userType);

        systemName = username;
        if (isValidLogin == true) {
            if (userType.equalsIgnoreCase("client")) {

                return "redirect:/home";

            }

        } else if (userType.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin") && username.equalsIgnoreCase("admin")) {
            return "redirect:/home";
        }

        return "redirect:/login";
    }

}
