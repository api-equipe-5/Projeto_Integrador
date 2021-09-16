package com.example.PITime01.application.http.controllers;

import com.example.PITime01.application.dto.EmployeeDTO;
import com.example.PITime01.application.dto.PasswordDTO;
import com.example.PITime01.application.services.EmployeeService;
import com.example.PITime01.domain.Employee;
import com.example.PITime01.domain.Profile;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

// TODO: PAGINAR A PAGINA DE LISTAGEM
@Controller
public class EmployeeController implements WebMvcConfigurer {

    private final EmployeeService employeeService;

    private final String viewFolder = "employee/";

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/new")
    public String newEmployee(Model model) {
        // TODO: Validar CPF la no HTML com Javascript antes de submeter o formulario!

        Employee employee = new Employee();
        model.addAttribute("cliente", employee);
        model.addAttribute("availableProfiles", Profile.values());
        return viewFolder + "new";
    }

    @GetMapping("/employee/password")
    public String editPassword(Model model, PasswordDTO passwordDto) {
        model.addAttribute("passwordDto", passwordDto);
        return "password";
    }

    @PostMapping("/employee/password")
    public String editPassword(Model model, PasswordDTO passwordDto, BindingResult result) {

        if (!employeeService.checkPassword(passwordDto.getCurrentPassword())) {
            result.rejectValue("currentPassword", null, "incorrect password");
        }

        if (!passwordDto.getNewPassword().equals(passwordDto.getConfirmPassword())) {
            result.rejectValue("newPassword", null, "new password doesn't match");
        }

        if (result.hasErrors()) {
            model.addAttribute("passwordDto", passwordDto);
            return "password";
        }

        employeeService.changePassword(passwordDto.getNewPassword());
        return "redirect:/";
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/driver/login").setViewName("driver/login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @RequestMapping("/employee/edit/{id}")
    public String editEmployee(@PathVariable(name = "id") Long id, Model model) {
        // TODO: Adicionar um combobox igual o de Perfis que tem na aba NEW, so que pra Status na pagina de EDIT
        Employee employee = employeeService.findByID(id);
        model.addAttribute("cliente", employee);
        model.addAttribute("availableProfiles", Profile.values());
        return viewFolder + "edit";
    }

    @RequestMapping(value = "/employee/edit", method = RequestMethod.POST)
    public String editEmployee(@ModelAttribute("cliente") Employee employee) {
        Employee foundEmployee = employeeService.findByID(employee.getId());
        foundEmployee.setName(employee.getName());
        foundEmployee.setRegistration(employee.getRegistration());
        employeeService.save(foundEmployee);
        return "redirect:/employee/list";
    }

    @RequestMapping("/employee/list")
    public String listEmployee(Model model) {
        List<EmployeeDTO> userList = employeeService.listAll();
        model.addAttribute("clienteList", userList);
        model.addAttribute("cliente", userList);

        return viewFolder + "list";
    }

    @RequestMapping(value = "/employee/save", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("cliente") Employee employee) {
        employeeService.save(employee);

        return "redirect:/employee/list";
    }

    @RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") long id) {
        // TODO: ROLES MUST HAVE PRIORITY (lower roles cannot edit higher ones!!)
        employeeService.delete(id);
        return "redirect:/employee/list";
    }


}
