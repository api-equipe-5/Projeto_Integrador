package com.example.PITime01.application.http.controllers;

import com.example.PITime01.application.services.UnionService;
import com.example.PITime01.domain.Union;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Controller
public class UnionController implements WebMvcConfigurer {

    private final UnionService service;

    private final String viewFolder = "union/";

    public UnionController(UnionService service) {
        this.service = service;
    }

    @RequestMapping("/union/new")
    public String newUnion(Model model) {
        Union union = new Union();
        model.addAttribute("union", union);
        return viewFolder + "new";
    }

    @RequestMapping(value = "/union/save", method = RequestMethod.POST)
    public String saveUnion(@ModelAttribute("union") Union union) {
        service.save(union);

        return "redirect:/union/list";
    }

    @RequestMapping("/union/list")
    public String listUnion(Model model) {
        List<Union> unionList = service.listAll();
        model.addAttribute("unionList", unionList);
        model.addAttribute("union", unionList);

        return viewFolder + "list";
    }

    @RequestMapping(value = "/union/edit", method = RequestMethod.POST)
    public String editEmployee(@ModelAttribute("union") Union union) {
        Union foundUnion = service.get(union.getId());
        foundUnion.setName(union.getName());
        foundUnion.setWorkingHours(union.getWorkingHours());
        foundUnion.setRestingHours(union.getRestingHours());
        foundUnion.setFirstFraction(union.getFirstFraction());
        foundUnion.setSecondFraction(union.getSecondFraction());
        foundUnion.setThirdFraction(union.getThirdFraction());
        foundUnion.setLunchTime(union.getLunchTime());
        foundUnion.setTimeOff(union.getTimeOff());
        foundUnion.setAllowedExtraHours(union.getAllowedExtraHours());
        foundUnion.setAllowedClockHours(union.getAllowedClockHours());
        service.save(foundUnion);
        return "redirect:/employee/list";
    }

    @RequestMapping("/union/edit/{id}")
    public String editUnion(@PathVariable(name = "id") Long id, Model model) {
        Union union = service.get(id);
        model.addAttribute("sindicato", union);

        return viewFolder + "edit";
    }

    @RequestMapping(value = "/union/delete/{id}", method = RequestMethod.GET)
    public String deleteUnion(@PathVariable("id") long id) {
        service.delete(id);
        return "redirect:/union/list";
    }

}
