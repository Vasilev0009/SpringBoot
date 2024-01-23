package ru.vasilev.SpringBootLab6.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.vasilev.SpringBootLab6.entity.Student;

@Data
@Builder
public class ResponseStudent {
    private String serviceMessage;  // Сервисное сообщение
    private Student student; // Данные одного студента
}