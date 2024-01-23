package ru.vasilev.SpringBootLab8.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="STUDENTS")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="age")
    private int age;
}
