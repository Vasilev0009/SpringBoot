package ru.vasilev.SpringBootLab2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @NotBlank(message = "uid не должно быть пустым")
    @Size(max = 32, message = "размер uid должен находиться в диапазоне от 1 до 32 символов")
    private String uid;

    @NotBlank(message = "operationUid не должно быть пустым")
    @Size(max = 32, message = "размер operationUid должен находиться в диапазоне от 1 до 32 символов")
    private String operationUid;

    private String systemName;
    @NotBlank(message = "systemTime не должно быть пустым")
    private String systemTime;

    private String source;

    @Min(value = 1,message = "communicationId должно быть не меньше 1")
    @Max(value = 100000, message = "communicationId должно быть не больше 100000")
    private int communicationId;

    private int templateId;
    private int productCode;
    private int smsCode;
}
