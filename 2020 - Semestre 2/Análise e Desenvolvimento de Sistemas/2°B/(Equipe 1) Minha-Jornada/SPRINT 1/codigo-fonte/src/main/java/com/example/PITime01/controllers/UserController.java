package com.example.PITime01.controllers;

import com.example.PITime01.user.Profile;
import com.example.PITime01.user.UserDTO;
import com.example.PITime01.user.UserService;
import com.example.PITime01.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Controller
public class UserController implements WebMvcConfigurer {
    @Autowired
    private UserService service;

    @RequestMapping("/")
    public String userHomePage(Model model){
        return "index";
    }

    @RequestMapping("/user/new")
    public String showNewClientForm(Model model){
        User user = new User();
        model.addAttribute("cliente", user);
        model.addAttribute("availableProfiles", Profile.values());
        return "new_client";
    }

    @RequestMapping("/user/edit/{userId}")
    public ModelAndView showEditClientForm(@PathVariable(name = "userId")Long id){
        ModelAndView mav = new ModelAndView("edit_product");
        User user = service.get(id);
        mav.addObject("cliente", user);

        return mav;
    }

    @RequestMapping("/user/list")
    public String showClientList(Model model){
        List<UserDTO> userList = service.listAll();
        model.addAttribute("clienteList", userList);
        model.addAttribute("cliente", userList);

        return "list";
    }

    @RequestMapping(value = "/user/save",method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("cliente") User user){
        service.save(user);

        return "redirect:/";
    }

    @RequestMapping(value = "/user/edit",method = RequestMethod.POST)
    public String editClient(@ModelAttribute("cliente") User user){
        User foundUser = service.get(user.getId());
        foundUser.setName(user.getName());
        service.save(foundUser);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public String deleteClient(@PathVariable("id") long id){
        // TOODO: ROLES MUST HAVE PRIORITY
        service.delete(id);
        return "redirect:/user/list";
    }
}
