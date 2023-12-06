package ru.vasilev.SpringBootLab3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/***
 * СПИСОК ИМЕЮЩИХСЯ ДОЛЖНОСТЕЙ
 */
@Getter
@AllArgsConstructor
public enum Positions {
    DEV ("Developer", 2.2, false), // Девелопер
    HR ("HR",1.2, false), // HR-specialist
    TL("TL Manager",2.6, true), // TL-Менеджер
    QA("QA-engineer",2.0, false), // QA-инженер
    MARKETING("Marketing specialist",1.8, false), // Маркетолог
    MANAGER ("Manager specialist", 1.8, true); // Менеджер

    private final String name; //Должность
    private final double rate; // Коэффициент премии
    private final boolean QuarterlyBonus; // true - квартальная премия; false - годовая
}
