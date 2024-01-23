package ru.vasilev.SpringBootLab6.dao.model;

import lombok.Builder;
import lombok.Data;
import ru.vasilev.SpringBootLab6.entity.Discipline;

import java.util.List;
@Data
@Builder
public class ResponseAllDiscipline {
    private String serviceMessage;  // Сервисное сообщение
    private List<Discipline> disciplineService;  // Cписок дисциплин
}
