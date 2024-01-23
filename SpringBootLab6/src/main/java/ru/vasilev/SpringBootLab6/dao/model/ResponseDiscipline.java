package ru.vasilev.SpringBootLab6.dao.model;

import lombok.Builder;
import lombok.Data;
import ru.vasilev.SpringBootLab6.entity.Discipline;

@Data
@Builder
public class ResponseDiscipline {
    private String serviceMessage;  // Сервисное сообщение
    private Discipline discipline; //Данные одной дисциплины
}
