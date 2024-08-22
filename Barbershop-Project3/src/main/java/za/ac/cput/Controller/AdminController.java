package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import za.ac.cput.domain.Admin;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.service.AdminService;

@Controller
public class AdminController {
    @Autowired
    private AdminService service;

    @GetMapping("/admin")
    public String getAdmin(Model model) {
        model.addAttribute("heading", "Admin List");
        model.addAttribute("admin", service.getAll());
        return "admin";
    }

    @GetMapping("/admin/add")
    public String showAddAdminForm(Model model) {
        // Pass an empty form object
        model.addAttribute("admin", new Admin());
        return "admin-form"; // Return the form view name
    }

    @PostMapping("/admin/add")
    public String addAdmin(@ModelAttribute("admin") Admin adminForm) {
        System.out.println("Admin ID: " + adminForm.getAdmin_id());
        System.out.println("Username: " + adminForm.getUsername());
        System.out.println("Password: " + adminForm.getPassword());
        // Create Admin object using the factory
        Admin admin = AdminFactory.buildAdmin(adminForm.getAdmin_id(), adminForm.getUsername(), adminForm.getPassword());
        service.create(admin);
        return "redirect:/admin";
    }
}
