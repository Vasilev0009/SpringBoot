package ru.vasilev.SpringBootLab6.service;

import org.springframework.stereotype.Service;
import ru.vasilev.SpringBootLab6.dao.StudentDAO;
import ru.vasilev.SpringBootLab6.entity.Student;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudents();

    Student getStudent(int id);

    Student saveStudent(Student student);

    void deleteStudent(int id);
}
