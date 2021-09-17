package com.example.PITime01.application.http.controllers;

import com.example.PITime01.application.services.DriverService;
import com.example.PITime01.application.services.EmployeeService;
import com.example.PITime01.application.services.JourneyService;
import com.example.PITime01.application.services.UnionService;
import com.example.PITime01.domain.*;
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
    private final JourneyService journeyService;
    private final EmployeeService employeeService;

    private final String viewFolder = "driver/";

    public DriverController(DriverService service, UnionService serviceUnion, JourneyService journeyService, EmployeeService employeeService) {
        this.service = service;
        this.unionService = serviceUnion;
        this.journeyService = journeyService;
        this.employeeService = employeeService;
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
        Employee employee = new Employee();
        employee.setName((driver.getName() + "." + driver.getSurname()).toLowerCase());
        employee.setPassword(driver.getPassword());
        employee.setCpf("111.111.11-11");
        employee.setProfile(Profile.DRIVER);
        employee.setRegistration("Driver.00" + driver.getId());
        employee.setStatus(Status.ACTIVE);
        employeeService.save(employee);


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

    @RequestMapping("/indexDriver")
    public String userHomePage(Model model) {

        return "driver/indexDriver";
    }

    @RequestMapping("/driver/visualize/{id}")
    public String visualizeEmployee(@PathVariable(name = "id") Long id, Model model) {
        // TODO: Adicionar um combobox igual o de Perfis que tem na aba NEW, so que pra Status na pagina de EDIT
        Driver driver = service.get(id);
        List<Journey> allJourney = journeyService.listAll();
        allJourney = (allJourney.stream().filter(journey -> id == journey.getIdDriver())).collect(Collectors.toList());
        model.addAttribute("driver", driver);
        model.addAttribute("journeyList", allJourney);
        model.addAttribute("journey", allJourney);

        return viewFolder + "visualize";
    }
}

