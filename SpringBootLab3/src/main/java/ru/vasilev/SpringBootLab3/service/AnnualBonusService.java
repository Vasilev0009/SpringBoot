package ru.vasilev.SpringBootLab3.service;

import org.springframework.stereotype.Service;
import ru.vasilev.SpringBootLab3.model.Positions;

/***
 * Интерфейс для расчета годовой (квартальной) премии
 */
@Service
public interface AnnualBonusService {
    double calculate(Positions positions, double salary, double bonus, int workDays);
}
