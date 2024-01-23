package ru.vasilev.SpringBootLab7.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "STUDENTS")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "faculty")
    private String faculty;
    @Column(name = "age")
    private int age;
}