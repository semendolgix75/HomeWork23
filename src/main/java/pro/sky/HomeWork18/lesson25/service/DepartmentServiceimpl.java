package pro.sky.HomeWork18.lesson25.service;

import org.springframework.stereotype.Service;
import pro.sky.HomeWork18.lesson25.exception.EmployeeNotFoundException;
import pro.sky.HomeWork18.lesson25.model.Employee;

import static java.util.Comparator.comparing;

@Service
public class DepartmentServiceimpl implements DepartmentService {
    private EmployeeService employeeService;

    public DepartmentServiceimpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public Employee searchMaxSalaryDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentNumber() == department)
                .max(comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }
}
