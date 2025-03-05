package com.bridgelabz.EmployeePayrollApp.Controller;
import com.bridgelabz.EmployeePayrollApp.Entity.Employee;
import com.bridgelabz.EmployeePayrollApp.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // GET all employees
    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // GET employee by ID
    @GetMapping("/get/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // POST - Create a new employee
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // PUT - Update an employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    // DELETE - Remove an employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee with ID " + id + " deleted successfully.";
    }
}


//curl localhost:8080/employeepayrollservice/ -w "\n"
//curl localhost:8080/employeepayrollservice/get/1 -w "\n"
//curl -X POST -H "Content-Type: application/json" -d '{"name": "Lisa","salary": 2000}' "http://localhost:8080/employeepayrollservice/create" -w "\n"
//curl -X PUT -H "Content-Type: application/json" -d '{"name": "Lisa","salary": 2500}' "http://localhost:8080/employeepayrollservice/update/1" -w "\n"
//curl -X DELETE "http://localhost:8080/employeepayrollservice/delete/1" -w "\n"

