package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public String addAdmin(@RequestParam("adminId") String adminId,
                            @RequestParam("username") String username,
                            @RequestParam("password") String password, Model model) {
            Admin admin = AdminFactory.buildAdmin(adminId, username, password);
            service.create(admin);
        return "redirect:/admin";
    }

    @GetMapping("/admin/edit/{id}")
    public String showEditAdminForm(@PathVariable("id") String adminId, Model model) {
        Admin admin = service.read(adminId);
        if (admin != null) {
            model.addAttribute("admin", admin);
            return "admin-form"; // Return the form view name
        } else {
            System.out.println("Admin not found");
            return "redirect:/admin";
        }
    }

    @PostMapping("/admin/update")
    public String updateAdmin(@ModelAttribute("admin") Admin adminForm, BindingResult result, Model model,
                              @RequestParam("adminId") String adminId,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password) {
        if (result.hasErrors()) {
            return "admin-form"; // Return to the form if there are errors
        }

        Admin existingAdmin = service.read(adminId);
        if (existingAdmin != null) {
            Admin updatedAdmin = AdminFactory.buildAdmin(username, password);
            service.update(updatedAdmin);
            return "redirect:/admin";
        } else {
            System.out.println("Admin not found");
            return "redirect:/admin";
        }
    }

    @PostMapping("/admin/delete/{id}")
    public String deleteAdmin(@PathVariable("id") String adminId) {
        service.delete(adminId);
        System.out.println("Succesfully deleted admin from database");
        return "redirect:/admin";
    }

}
