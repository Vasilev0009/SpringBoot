package ru.vasilev.SpringBootLab6.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.vasilev.SpringBootLab6.entity.Student;

import java.util.List;

/***
 * ИСХОДЯЩЕЕ СООБЩЕНИЕ
 * Содержит передаваемые переменные
 */
@Data
@Builder
public class ResponseAllStudents{

    private String serviceMessage;  // Сервисное сообщение
    private List<Student> studentService;  // Cписок студентов
}