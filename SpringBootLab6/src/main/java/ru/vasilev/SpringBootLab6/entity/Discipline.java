package ru.vasilev.SpringBootLab6.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "DISCIPLINES")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "faculty")
    private String faculty;
}
