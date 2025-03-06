package com.bridgelabz.EmployeePayrollApp.Service;
import com.bridgelabz.EmployeePayrollApp.DTO.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.Entity.Employee;
import com.bridgelabz.EmployeePayrollApp.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployeeById(Long id) {

        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }



    public Employee saveEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee();
        employee.setSalary(employeeDTO.getSalary());
        employee.setName(employeeDTO.getName());

        System.out.println("Saving Employee: " + employee.getName());

        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, EmployeeDTO updatedEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setSalary(updatedEmployee.getSalary());
            employee.setName(updatedEmployee.getName());

            return employeeRepository.save(employee);
        }).orElse(null);
    }

    public void deleteEmployee(Long id) {

        employeeRepository.deleteById(id);
    }
}
