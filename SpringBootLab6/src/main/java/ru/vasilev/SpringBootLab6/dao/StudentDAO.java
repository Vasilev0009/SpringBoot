package ru.vasilev.SpringBootLab6.dao;

import org.springframework.stereotype.Repository;
import ru.vasilev.SpringBootLab6.entity.Student;

import java.util.List;

@Repository
public interface StudentDAO {
    List<Student> getAllStudents();
    Student saveStudent(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);

}