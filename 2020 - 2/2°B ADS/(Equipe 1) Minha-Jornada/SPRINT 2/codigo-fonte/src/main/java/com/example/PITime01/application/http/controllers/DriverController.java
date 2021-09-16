package com.example.PITime01.application.http.controllers;

import com.example.PITime01.application.services.DriverService;
import com.example.PITime01.application.services.UnionService;
import com.example.PITime01.domain.Driver;
import com.example.PITime01.domain.Licenses;
import com.example.PITime01.domain.Union;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DriverController implements WebMvcConfigurer {

    private final DriverService service;
    private final UnionService unionService;

    private final String viewFolder = "driver/";

    public DriverController(DriverService service, UnionService serviceUnion) {
        this.service = service;
        this.unionService = serviceUnion;
    }

    @RequestMapping("/driver/new")
    public String newUnion(Model model) {
        Driver driver = new Driver();
        model.addAttribute("driver", driver);
        model.addAttribute("availableLicenses", Licenses.values());

        List<String> unionList = unionService.listAll().stream().map(Union::getName).collect(Collectors.toList());
        model.addAttribute("unionList", unionList);

        return viewFolder + "new";
    }

    @RequestMapping(value = "/driver/save", method = RequestMethod.POST)
    public String saveDriver(@ModelAttribute("driver") Driver driver) {
        service.save(driver);

        return "redirect:/driver/list";
    }

    @RequestMapping("/driver/list")
    public String listDriver(Model model) {
        List<Driver> driverList = service.listAll();
        model.addAttribute("driverList", driverList);
        model.addAttribute("driver", driverList);

        return viewFolder + "list";
    }

    @RequestMapping(value = "/driver/edit", method = RequestMethod.POST)
    public String editDriver(@ModelAttribute("driver") Driver driver) {
        Driver foundDriver = service.get(driver.getId());
        foundDriver.setName(driver.getName());
        foundDriver.setSurname(driver.getSurname());
        foundDriver.setCategoryLicense(driver.getCategoryLicense());
        foundDriver.setYearAdmission(driver.getYearAdmission());
        foundDriver.setUnionName(driver.getUnionName());
        foundDriver.setEmail(driver.getEmail());
        service.save(foundDriver);
        return "redirect:/driver/list";
    }

    @RequestMapping("/driver/edit/{id}")
    public String editDriver(@PathVariable(name = "id") Long id, Model model) {
        Driver driver = service.get(id);
        model.addAttribute("driver", driver);

        return viewFolder + "edit";
    }

    @RequestMapping(value = "/driver/delete/{id}", method = RequestMethod.GET)
    public String deleteDriver(@PathVariable("id") long id) {
        service.delete(id);
        return "redirect:/driver/list";
    }
}

