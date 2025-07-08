package com.example.Springbootfirstproject.Services;

import com.example.Springbootfirstproject.Models.Employee;
import com.example.Springbootfirstproject.Models.Student;
import com.example.Springbootfirstproject.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {

    private ArrayList<Employee> l = new ArrayList<>(Arrays.asList(
            new Employee(1, "SUMO", "doctor", "500"),
            new Employee(2, "abc", "developer", "600")
    ));

    public ArrayList<Employee> getEmp() {
        return l;
    }

    public void addEmployee(Employee emp) {
        l.add(emp);
    }

    public boolean updateEmployee(Employee emp) {
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getEmpid() == emp.getEmpid()) {
                l.set(i, emp);
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployee(Employee emp) {
        return l.removeIf(e -> e.getEmpid() == emp.getEmpid());
    }

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public boolean saveStudent(Student student) {
        try {
            studentRepo.save(student);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateStudent(Student student) {
        try {
            studentRepo.save(student);  // works for both new and existing records
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteStudent(int rollno) {
        try {
            if (studentRepo.existsById(rollno)) {
                studentRepo.deleteById(rollno);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String hello() {
        return "hello from GetMapping";
    }

    public String postHello() {
        return "hello from postHello";
    }

    public String PutMapping() {
        return "Hello from PutMapping";
    }

    public String Deletemapping() {
        return "Hello From DeleteMapping";
    }
}
