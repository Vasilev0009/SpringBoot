package ru.vasilev.SpringBootLab2.model;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Responce {

    private String uid;
    private String operationUid;
    private String systemTime;
    private String code;
    private String errorCode;
    private String errorMessage;
}
