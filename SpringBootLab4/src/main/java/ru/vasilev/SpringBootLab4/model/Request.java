package ru.vasilev.SpringBootLab4.model;

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

    @NotBlank(message = "uid не должно быть пустым")
    @Size(max = 32, message = "размер uid должен находиться в диапазоне от 1 до 32 символов")
    private String uid;

    @NotBlank(message = "operationUid не должно быть пустым")
    @Size(max = 36, message = "размер operationUid должен находиться в диапазоне от 1 до 32 символов")
    private String operationUid;

    private Systems systemName;

    @NotBlank(message = "systemTime не должно быть пустым")
    private String systemTime;

    private String source;

    @Min(value = 1,message = "communicationId должно быть не меньше 1")
    @Max(value = 100000, message = "communicationId должно быть не больше 100000")
    private int communicationId;

    private int templateId;
    private int productCode;
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
