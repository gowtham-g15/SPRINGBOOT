package com.example.Springbootfirstproject.Controller;

import com.example.Springbootfirstproject.Models.Employee;
import com.example.Springbootfirstproject.Models.Student;
import com.example.Springbootfirstproject.Services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService sws;

    @GetMapping("/hello")
    public String hello() {
        return sws.hello();
    }

    @PostMapping("/hello")
    public String postHello() {
        return sws.postHello();
    }

    @PutMapping("/hello")
    public String putMapping() {
        return sws.PutMapping();
    }

    @DeleteMapping("/hello")
    public String deleteMapping() {
        return sws.Deletemapping();
    }

    // ---------- Employee APIs ----------
    @GetMapping("/employees")
    public ArrayList<Employee> getEmployees() {
        return sws.getEmp();
    }

    @PostMapping("/employees")
    public String addEmployee(@RequestBody Employee emp) {
        sws.addEmployee(emp);
        return "Employee added successfully!";
    }

    @PutMapping("/employees")
    public String updateEmployee(@RequestBody Employee emp) {
        boolean success = sws.updateEmployee(emp);
        return success ? "Employee updated successfully!" : "Failed to update employee.";
    }

    @DeleteMapping("/employees")
    public String deleteEmployee(@RequestBody Employee emp) {
        boolean success = sws.deleteEmployee(emp);
        return success ? "Employee deleted successfully!" : "Failed to delete employee.";
    }

    // ---------- Student APIs ----------
    @GetMapping("/students")
    public List<Student> getStudents() {
        return sws.getAllStudents();
    }

    @PostMapping("/students")
    public String postStudent(@RequestBody Student student) {
        boolean success = sws.saveStudent(student);
        return success ? "Student saved successfully!" : "Failed to save student.";
    }

    @PutMapping("/students")
    public String updateStudent(@RequestBody Student student) {
        boolean success = sws.updateStudent(student);
        return success ? "Student updated successfully!" : "Failed to update student.";
    }

    @DeleteMapping("/students")
    public String deleteStudent(@RequestBody Student student) {
        boolean success = sws.deleteStudent(student.getRollno());
        return success ? "Student deleted successfully!" : "Failed to delete student.";
    }
}
