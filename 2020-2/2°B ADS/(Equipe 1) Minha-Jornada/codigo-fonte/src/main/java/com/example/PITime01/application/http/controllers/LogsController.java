package com.example.PITime01.application.http.controllers;

import com.example.PITime01.application.dto.audit.DriverAuditDTO;
import com.example.PITime01.application.dto.audit.EmployeeAuditDTO;
import com.example.PITime01.application.dto.audit.UnionAuditDTO;
import com.example.PITime01.application.dto.audit.VehicleAuditDTO;
import com.example.PITime01.application.services.DriverService;
import com.example.PITime01.application.services.EmployeeService;
import com.example.PITime01.application.services.UnionService;
import com.example.PITime01.application.services.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Controller
public class LogsController implements WebMvcConfigurer {


    private final EmployeeService employeeService;
    private final UnionService unionService;
    private final DriverService driverService;
    private final VehicleService vehicleService;

    public LogsController(EmployeeService employeeService, UnionService unionService, DriverService driverService, VehicleService vehicleService) {
        this.employeeService = employeeService;
        this.unionService = unionService;
        this.driverService = driverService;
        this.vehicleService = vehicleService;
    }

    @RequestMapping("employee/audit")
    public String auditEmployee(Model model) {

        List<EmployeeAuditDTO> rep = employeeService.listAllAudit();
        model.addAttribute("clienteList", rep);

        return "employee/audit";
    }

    @RequestMapping("audit")
    public String auditAllEmployee(Model model) {

        List<EmployeeAuditDTO> rep = employeeService.listAllAudit();
        List<UnionAuditDTO> rep2 = unionService.listAllAudit();
        List<DriverAuditDTO> rep3 = driverService.listAllAudit();
        List<VehicleAuditDTO> rep4 = vehicleService.listAllAudit();
        model.addAttribute("clienteList", rep);
        model.addAttribute("unionList", rep2);
        model.addAttribute("driverList", rep3);
        model.addAttribute("vehicleList", rep4);

        return "audit";
    }

    @RequestMapping("union/audit")
    public String auditUnion(Model model) {

        List<UnionAuditDTO> rep = unionService.listAllAudit();
        model.addAttribute("unionList", rep);

        return "union/audit";
    }

    @RequestMapping("driver/audit")
    public String auditDriver(Model model) {

        List<DriverAuditDTO> rep = driverService.listAllAudit();
        model.addAttribute("driverList", rep);

        return "driver/audit";
    }

    @RequestMapping("vehicle/audit")
    public String auditVehicle(Model model) {

        List<VehicleAuditDTO> rep = vehicleService.listAllAudit();
        model.addAttribute("vehicleList", rep);

        return "vehicle/audit";
    }
}
