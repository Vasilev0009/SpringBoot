package ru.vasilev.SpringBootLab3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    /***
     * Уникальный идентификатор сообщения
     */
    @NotBlank(message = "uid не должно быть пустым")
    @Size(max = 32, message = "размер uid должен находиться в диапазоне от 1 до 32 символов")
    private String uid;
    /***
     * Уникальный идентификатор операции
     */
    @NotBlank(message = "operationUid не должно быть пустым")
    @Size(max = 36, message = "размер operationUid должен находиться в диапазоне от 1 до 32 символов")
    private String operationUid;
    /***
     * Имя системы отправителя
     */
    private Systems systemName;
    /***
     * Время создания сообщения
     */
    @NotBlank(message = "systemTime не должно быть пустым")
    private String systemTime;
    /***
     * Наименование ресурса
     */
    private String source;
    /***
     * Должность
     */
    private Positions position;
    /***
     * Заработная плата
     */
    private Double salary;
    /***
     * Коэффициент премии
     */
    private Double bonus;
    /***
     * Отработанные дни
     */
    @Min(value = 1,message = "communicationId должно быть не меньше 1")
    @Max(value = 365, message = "communicationId должно быть не больше 100000")
    private Integer workDays;
    /***
     * Уникальный идентификатор коммуникации
     */
    @Min(value = 1,message = "communicationId должно быть не меньше 1")
    @Max(value = 100000, message = "communicationId должно быть не больше 100000")
    private int communicationId;
    /***
     * Уникальный идентификатор шаблона
     */
    private int templateId;
    /***
     * Код продукта
     */
    private int productCode;
    /***
     * Смс код
     */
    private int smsCode;

    @Override
    public String toString() {
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId=" + communicationId +
                ", templateId=" + templateId +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                '}';
    }
}
