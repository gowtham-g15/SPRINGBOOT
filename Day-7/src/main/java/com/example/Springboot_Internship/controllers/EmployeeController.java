package com.example.Springboot_Internship.controllers;


import com.example.Springboot_Internship.models.RegisterDetails;
import com.example.Springboot_Internship.models.Todo;
import com.example.Springboot_Internship.models.UserDetailsDto;
import com.example.Springboot_Internship.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String route(){
        return "Welcome to SpringBoot Security";
    }


    @GetMapping("/employee")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<RegisterDetails> getMethod(){
        return employeeService.getMethod();
    }


    @GetMapping("/employee/{empId}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public RegisterDetails getEmployeeById(@PathVariable int empId){
        System.out.println();
        return employeeService.getEmployeeById(empId);
    }



//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    @GetMapping("/employee/job/{job}")
//    public List<RegisterDetails> getEmployeeByJob(@PathVariable String job){
//        return employeeService.getEmployeeByJob(job);
//    }

    @PostMapping("/employee")
    @PreAuthorize("hasRole('ADMIN')")
    public String postMethod(@RequestBody RegisterDetails employee){
//        Employee employee = new Employee(5,"Sivagami", "Business");
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/employee/{empId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String putMethod(@PathVariable int empId){
        return employeeService.updateEmployee(empId);
    }

    @DeleteMapping("/employee/{empID}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteMethod(@PathVariable int empID){
        return employeeService.deleteEmployeeById(empID);
    }
    @PutMapping("/employee/{empId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateEmployee(@PathVariable int empId, @RequestBody RegisterDetails updatedDetails) {
        return employeeService.updateEmployee(empId);
    }

    @GetMapping("/employee/role/{role}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<RegisterDetails> getByRole(@PathVariable String role) {
        return employeeService.getEmployeesByRole(role);
    }

    @PostMapping("/employee/{empId}/todo")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String addTodo(@PathVariable int empId, @RequestBody Todo todo) {
        return employeeService.addTodo(empId, todo);
    }

    @GetMapping("/employee/{empId}/todos")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<Todo> getTodos(@PathVariable int empId) {
        return employeeService.getTodos(empId);
    }



}