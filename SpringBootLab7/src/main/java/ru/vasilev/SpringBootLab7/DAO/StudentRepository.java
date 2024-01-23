package ru.vasilev.SpringBootLab7.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vasilev.SpringBootLab7.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
