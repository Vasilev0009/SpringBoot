package ru.vasilev.SpringBootLab3.service;

import org.junit.jupiter.api.Test;
import ru.vasilev.SpringBootLab3.model.Positions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class YearBonusServiceTest {

    @Test
    void calculate() {
        Positions position = Positions.HR;
        double bonus = 1.2;
        int workDays = 245;
        double salary = 70000.00;
        double result = new YearBonusService().calculate(position,salary,bonus,workDays);
        double expected = 56383.561643835616;
        assertThat(result).isEqualTo(expected);
    }

}