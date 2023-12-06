package ru.vasilev.SpringBootLab3.service;

import org.springframework.stereotype.Service;
import ru.vasilev.SpringBootLab3.model.Positions;

import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.util.Date;

import java.util.Calendar;

/***
 * Класс для расчета годовой премии
 */
@Service
public class YearBonusService implements AnnualBonusService{
    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays) {
        int AllDays; //Кол-во дней в отчетном периоде
        if(positions.isQuarterlyBonus()){
            // Определение кол-ва дней в текущем квартале
            LocalDate myLocal = LocalDate.now();
            AllDays = myLocal.get(IsoFields.QUARTER_OF_YEAR);
        }else {
            // Определение кол-ва дней в текущем году
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            AllDays = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
        }
        // Возвращает значение годовой премии
        return salary * bonus * workDays / AllDays;
    }
}