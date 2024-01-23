package ru.vasilev.SpringBootLab6.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vasilev.SpringBootLab6.dao.StudentDAO;
import ru.vasilev.SpringBootLab6.entity.Student;

import java.util.List;

@Service
@Getter
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDAO;
    private String serviceMessage;
    private List<Student> studentList;

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        studentList = studentDAO.getAllStudents();
        if(studentList.isEmpty()) {
            serviceMessage = "no records in the database";
        } else {
            serviceMessage = "operation was completed successfully";
        }

        return studentList;
    }

    @Override
    @Transactional
    public Student getStudent(int id) {
        if(studentDAO.getStudent(id) == null) {
            serviceMessage = "no records in the database";
        } else {
            serviceMessage = "operation was completed successfully";
        }
        return studentDAO.getStudent(id);
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return studentDAO.saveStudent(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }

    public String serviceMessage(){ return serviceMessage;}
}
