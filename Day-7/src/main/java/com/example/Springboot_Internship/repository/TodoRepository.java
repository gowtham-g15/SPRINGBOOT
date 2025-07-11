package com.example.Springboot_Internship.repository;

import com.example.Springboot_Internship.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByEmployeeEmpId(int empId);
}
