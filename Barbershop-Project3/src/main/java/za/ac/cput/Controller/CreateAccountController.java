package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.cput.api.CreateAccountAPI;
import za.ac.cput.domain.Client;

@Controller
public class CreateAccountController {

    private final CreateAccountAPI createAccountAPI;
    private static Client client;

    @Autowired
    CreateAccountController(CreateAccountAPI createAccountAPI){this.createAccountAPI=createAccountAPI;}

    @GetMapping("/signup")
    public String getMethodName(Model model) {
        model.addAttribute("createAccount", new Client());
        return "signup";
    }
    @PostMapping("/saveAccount")
    public String saveAccount(@RequestParam String username, @RequestParam String password, @RequestParam String userType, @RequestParam String email,@RequestParam String phone,@RequestParam String firstName,@RequestParam String surname, Model model) {
        client=createAccountAPI.createClient(username,password,userType,email,phone,firstName,surname);
        createAccountAPI.saveClient(client);
        return "redirect:/login";
    }


}

