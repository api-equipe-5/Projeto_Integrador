package com.example.PITime01.application.http.controllers;

import com.example.PITime01.application.services.VehicleService;
import com.example.PITime01.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VehicleController {
    @Autowired
    private VehicleService service;
    private final String viewFolder = "vehicle/";

    @RequestMapping("/vehicle/list")
    public String viewVehicleHomePage(Model model){
        List<Vehicle> listVehicles=service.listAll();
        model.addAttribute("listVehicles",listVehicles);
        model.addAttribute("vehicle",listVehicles);
        return viewFolder+"list";
    }

    @RequestMapping("/vehicle/new")
    public String showNewVehicleForm(Model model) {
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle);

        return viewFolder + "new";
    }

    @RequestMapping(value ="vehicle/save", method= RequestMethod.POST)
    public String saveVehicle(@ModelAttribute("vehicle") Vehicle vehicle){
        service.Save(vehicle);
        return "redirect:/vehicle/list";
    }

    @RequestMapping("/vehicle/edit/{id}")
    public ModelAndView showEditVehicleForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("vehicle/edit");
        Vehicle vehicle = service.get(id);
        mav.addObject("vehicle", vehicle);
        return mav;
    }

    @RequestMapping("/vehicle/delete/{id}")
    public String deleteProduct(@PathVariable(name="id") Long id){
        service.delete(id);
        return "redirect:/vehicle/list";
    }
}
