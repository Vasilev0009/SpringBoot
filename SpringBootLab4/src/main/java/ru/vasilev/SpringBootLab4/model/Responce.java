package ru.vasilev.SpringBootLab4.model;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Responce {

    private String uid;
    private String operationUid;
    private String systemTime;
    private Codes code;
    private ErrorCodes errorCode;
    private ErrorMessages errorMessage;
}
