package ru.vasilev.SpringBootLab6.service;

import org.springframework.stereotype.Service;
import ru.vasilev.SpringBootLab6.entity.Discipline;

import java.util.List;
@Service
public interface DisciplineService {

    List<Discipline> getAllDiscipline();

    Discipline getDiscipline(int id);

    Discipline saveDiscipline(Discipline discipline);

    void deleteDiscipline(int id);
}
