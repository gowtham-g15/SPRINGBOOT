package com.example.Springboot_Internship.services;

import com.example.Springboot_Internship.models.RegisterDetails;
import com.example.Springboot_Internship.models.Todo;
import com.example.Springboot_Internship.models.UserDetailsDto;
import com.example.Springboot_Internship.repository.RegisterDetailsRepository;
import com.example.Springboot_Internship.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    RegisterDetailsRepository registerDetailsRepository;


    public List<RegisterDetails> getMethod() {
        return registerDetailsRepository.findAll();
    }

    public RegisterDetails getEmployeeById(int empId) {
        return registerDetailsRepository.findById(empId).orElse(new RegisterDetails());
    }

//    public List<RegisterDetails> getEmployeeByJob() {
//        return registerDetailsRepository.findByRole();
//    }

    public String addEmployee(RegisterDetails employee) {
        registerDetailsRepository.save(employee);
        return "Employee Added Successfully";
    }

    public String updateEmployee(int empId) {
        RegisterDetails user = registerDetailsRepository.findById(empId)
                .orElseThrow(()->new RuntimeException("No Such User Present"));
        registerDetailsRepository.save(user);
        return "Employee Updated Successfully";
    }

    public String deleteEmployeeById(int empID) {
        registerDetailsRepository.deleteById(empID);
        return "Employee Deleted Successfully";
    }

    public List<RegisterDetails> getEmployeesByRole(String roleName) {
        return registerDetailsRepository.findAll().stream()
                .filter(emp -> emp.getRoles().stream()
                        .anyMatch(role -> role.getRoleName().equalsIgnoreCase(roleName)))
                .collect(Collectors.toList());
    }
    @Autowired
    TodoRepository todoRepository;
    public String addTodo(int empId, Todo todo) {
        RegisterDetails emp = registerDetailsRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        todo.setEmployee(emp);
        todoRepository.save(todo);
        return "Todo Added Successfully";
    }
    public List<Todo> getTodos(int empId) {
        return todoRepository.findByEmployeeEmpId(empId);
    }
}