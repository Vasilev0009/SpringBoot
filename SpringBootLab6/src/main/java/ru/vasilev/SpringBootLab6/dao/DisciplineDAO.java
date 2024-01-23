package ru.vasilev.SpringBootLab6.dao;

import org.springframework.stereotype.Repository;
import ru.vasilev.SpringBootLab6.entity.Discipline;

import java.util.List;
@Repository
public interface DisciplineDAO {
    List<Discipline> getAllDiscipline();
    Discipline saveDiscipline(Discipline discipline);

    Discipline getDiscipline(int id);

    void deleteDiscipline(int id);

}
