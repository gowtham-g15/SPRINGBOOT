package com.example.Springboot_Internship.models;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String task;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private RegisterDetails employee;
}
