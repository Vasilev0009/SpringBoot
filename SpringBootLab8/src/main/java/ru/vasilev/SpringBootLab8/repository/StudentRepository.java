package ru.vasilev.SpringBootLab8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vasilev.SpringBootLab8.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
