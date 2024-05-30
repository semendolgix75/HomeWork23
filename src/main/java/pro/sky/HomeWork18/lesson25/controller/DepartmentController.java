package pro.sky.HomeWork18.lesson25.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HomeWork18.lesson25.model.Employee;
import pro.sky.HomeWork18.lesson25.service.DepartmentService;
import pro.sky.HomeWork18.lesson25.service.EmployeeService;
import java.util.Collection;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }




}