package ru.vasilev.SpringBootLab6.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vasilev.SpringBootLab6.dao.DisciplineDAO;
import ru.vasilev.SpringBootLab6.entity.Discipline;

import java.util.List;

@Service
@Getter
public class DisciplineServiceImpl implements DisciplineService {
    @Autowired
    private DisciplineDAO DisciplineDAO;
    private String serviceMessage;
    private List<Discipline> disciplineList;

    @Override
    @Transactional
    public List<Discipline> getAllDiscipline() {
        disciplineList = DisciplineDAO.getAllDiscipline();
        if(disciplineList.isEmpty()) {
            serviceMessage = "no records in the database";
        } else {
            serviceMessage = "operation was completed successfully";
        }

        return disciplineList;
    }

    @Override
    @Transactional
    public Discipline getDiscipline(int id) {
        if(DisciplineDAO.getDiscipline(id) == null) {
            serviceMessage = "no records in the database";
        } else {
            serviceMessage = "operation was completed successfully";
        }
        return DisciplineDAO.getDiscipline(id);
    }

    @Override
    @Transactional
    public Discipline saveDiscipline(Discipline discipline) {
        return DisciplineDAO.saveDiscipline(discipline);
    }

    @Override
    @Transactional
    public void deleteDiscipline(int id) {
        DisciplineDAO.deleteDiscipline(id);
    }

    public String serviceMessage(){ return serviceMessage;}
}

