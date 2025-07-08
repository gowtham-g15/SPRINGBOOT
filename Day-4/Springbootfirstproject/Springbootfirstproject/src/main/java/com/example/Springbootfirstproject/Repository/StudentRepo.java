package com.example.Springbootfirstproject.Repository;

import com.example.Springbootfirstproject.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
