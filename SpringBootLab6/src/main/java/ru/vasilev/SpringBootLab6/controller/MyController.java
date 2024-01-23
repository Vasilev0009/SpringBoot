package ru.vasilev.SpringBootLab6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vasilev.SpringBootLab6.dao.model.ResponseAllDiscipline;
import ru.vasilev.SpringBootLab6.dao.model.ResponseAllStudents;
import ru.vasilev.SpringBootLab6.dao.model.ResponseDiscipline;
import ru.vasilev.SpringBootLab6.dao.model.ResponseStudent;
import ru.vasilev.SpringBootLab6.entity.Discipline;
import ru.vasilev.SpringBootLab6.entity.Student;
import ru.vasilev.SpringBootLab6.service.DisciplineServiceImpl;
import ru.vasilev.SpringBootLab6.service.StudentServiceImpl;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private DisciplineServiceImpl disciplineService;
    private String serviceMessage;
    @GetMapping("/students")
    public ResponseEntity<ResponseAllStudents> allStudents(){
        ResponseAllStudents responseAllStudents = ResponseAllStudents.builder()
                .studentService(studentService.getAllStudents())
                .serviceMessage(studentService.getServiceMessage())
                .build();
        return new ResponseEntity<>(responseAllStudents, HttpStatus.OK);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<ResponseStudent> student(@PathVariable int id){
        ResponseStudent responseStudent = ResponseStudent.builder()
                .student(studentService.getStudent(id))
                .serviceMessage(studentService.getServiceMessage())
                .build();
        return new ResponseEntity<>(responseStudent, HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<ResponseStudent> saveStudent(@RequestBody Student student) {
        ResponseStudent responseStudent = ResponseStudent.builder()
                .student(studentService.saveStudent(student))
                .serviceMessage("Добавлен студент:")
                .build();
        return new ResponseEntity<>(responseStudent, HttpStatus.OK);
    }
    @PutMapping("/students")
    public ResponseEntity<ResponseStudent> updateStudent(@RequestBody Student student){
        ResponseStudent responseStudent = ResponseStudent.builder()
                .student(studentService.saveStudent(student))
                .serviceMessage("Запись изменена:")
                .build();
        return new ResponseEntity<>(responseStudent, HttpStatus.OK);
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<ResponseStudent> deleteStudent(@PathVariable("id") int id) {
        ResponseStudent responseStudent = ResponseStudent.builder()
                .student(studentService.getStudent(id))
                .serviceMessage("Запись удалена:")
                .build();
        studentService.deleteStudent(id);
        return new ResponseEntity<>(responseStudent, HttpStatus.OK);
    }
    @GetMapping("/disciplines")
    public ResponseEntity<ResponseAllDiscipline> allDiscipline(){
        ResponseAllDiscipline responseAllDiscipline = ResponseAllDiscipline.builder()
                .disciplineService(disciplineService.getAllDiscipline())
                .serviceMessage(disciplineService.getServiceMessage())
                .build();
        return new ResponseEntity<>(responseAllDiscipline, HttpStatus.OK);
    }
    @GetMapping("/discipline/{id}")
    public ResponseEntity<ResponseDiscipline> discipline(@PathVariable int id){
        ResponseDiscipline responseDiscipline = ResponseDiscipline.builder()
                .discipline(disciplineService.getDiscipline(id))
                .serviceMessage(disciplineService.getServiceMessage())
                .build();
        return new ResponseEntity<>(responseDiscipline, HttpStatus.OK);
    }

    @PostMapping("/discipline")
    public ResponseEntity<ResponseDiscipline> saveDiscipline(@RequestBody Discipline discipline) {
        ResponseDiscipline responseDiscipline = ResponseDiscipline.builder()
                .discipline(disciplineService.saveDiscipline(discipline))
                .serviceMessage("Дисциплина добавлена")
                .build();
        return new ResponseEntity<>(responseDiscipline, HttpStatus.OK);
    }
    @PutMapping("/discipline")
    public ResponseEntity<ResponseDiscipline> updateDiscipline(@RequestBody Discipline discipline){
        ResponseDiscipline responseDiscipline = ResponseDiscipline.builder()
                .discipline(disciplineService.saveDiscipline(discipline))
                .serviceMessage("Запись изменена:")
                .build();
        return new ResponseEntity<>(responseDiscipline, HttpStatus.OK);
    }
    @DeleteMapping("/discipline/{id}")
    public ResponseEntity<ResponseDiscipline> deleteDiscipline(@PathVariable("id") int id) {
        ResponseDiscipline responseDiscipline = ResponseDiscipline.builder()
                .discipline(disciplineService.getDiscipline(id))
                .serviceMessage("Запись удалена:")
                .build();
        disciplineService.deleteDiscipline(id);
        return new ResponseEntity<>(responseDiscipline, HttpStatus.OK);
    }
}