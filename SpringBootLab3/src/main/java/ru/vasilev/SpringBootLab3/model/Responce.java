package ru.vasilev.SpringBootLab3.model;
import lombok.Builder;
import lombok.Data;

/***
 * ИСХОДЯЩЕЕ СООБЩЕНИЕ
 * Содержит передаваемые переменные
 */
@Data
@Builder
public class Responce {

    private String uid;  // Уникальный идентификатор сообщения
    private String operationUid;  // Уникальный идентификатор операции
    private String systemTime;  // Время создания сообщения
    private Codes code;  // Код
    private Double annualBonus;  // Годовой (квартальный) бонус
    private ErrorCodes errorCode;  // Код ошибки
    private ErrorMessages errorMessage;  // Сообщение об ошибке

}
