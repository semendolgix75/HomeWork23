package pro.sky.HomeWork18.lesson25.service;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pro.sky.HomeWork18.lesson25.exception.EmployeeAlreadyAddedException;
import pro.sky.HomeWork18.lesson25.exception.EmployeeNotFoundException;
import pro.sky.HomeWork18.lesson25.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String,Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();

    }

    @PostConstruct
    private void init(){
        add("Vasilyev","Vasiliy",1,68000);
        add("Dmitriev","Dmitriy",2,92000);
        add("Borisov","Boris",3,90000);
        add("Vladimirov","Vladimir",4,80000);
        add("Andreev","Andrey",5,70200);
        add("Hikolaev","Hikolay",1,85000);
        add("Ivanov ", "Ivan", 2, 70000);
        add("Petrov ", "Petr", 3, 68000);
        add("Sidorov ", "Sidor", 4, 75000);
        add("Alekseev ", "Aleksey", 5, 86000);
        add("Sergeev ", "Sergey", 1, 82000);
        add("Putin ", "Vladimir", 2, 75000);
        add("Haritonov ", "Nikolay", 3, 69000);
        add("Davankov ", "Vlad", 4, 71000);
        add("Slutskiy", "Leonid", 5, 76000);
    }
    @Override
    public Employee add(String firstName, String lastName, Integer departmentNumber, Integer salary){
        Employee employee = new Employee(firstName, lastName,departmentNumber,salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(),employee);
        return employee;
    }
    @Override
    public Employee remove (String firstName, String lastName, Integer departmentNumber, Integer salary){
        Employee employee = new Employee(firstName, lastName,departmentNumber,salary);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }
    @Override
    public Employee find (String firstName, String lastName, Integer departmentNumber, Integer salary){
        Employee employee = new Employee(firstName, lastName,departmentNumber,salary);
        if (employees.containsKey((employee.getFullName()))) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {

        return Collections.unmodifiableCollection(employees.values());
    }



}


