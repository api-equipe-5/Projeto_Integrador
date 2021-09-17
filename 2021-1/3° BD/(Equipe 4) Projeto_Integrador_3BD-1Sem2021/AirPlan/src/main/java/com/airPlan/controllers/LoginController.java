package com.airPlan.controllers;

import com.airPlan.entities.*;
import com.airPlan.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("/menu")
    public String menu() {

        return "menu";
    }

    @GetMapping("/create-user")
    public String createUser() {

        return "create-user";
    }

    @RequestMapping("/create-user")
    public String showLoginCreatePage(Model model) {
        General general = new General();
        model.addAttribute("general", general);

        return "create-user";
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("general") General general, RedirectAttributes redirAttrs, Model model){

        if(general.getEmp_password().isEmpty() || general.getEmp_name().isEmpty() || general.getEmp_last_name().isEmpty() ||
        general.getEmp_confirm_password().isEmpty() || general.getTyp_id() == 0) {
            redirAttrs.addFlashAttribute("error", "Incorrect data, check" +
                    " fields integrity.");

            return "redirect:/create-user";
        } else if(general.getEmp_password().equals(general.getEmp_confirm_password())){

            String name = general.getEmp_name() + " " + general.getEmp_last_name();

            User user = new User(name, general.getEmp_password(), general.getTyp_id());

            userService.save(user);

            model.addAttribute("msg", "Succesfully uploaded files ");

            redirAttrs.addFlashAttribute("success", "User successfully created to database.");

        } else {
            redirAttrs.addFlashAttribute("error", "Incorrect data, check if the passwords are the same.");
            return "redirect:/create-user";
        }

        return "redirect:/create-user";
    }
}
