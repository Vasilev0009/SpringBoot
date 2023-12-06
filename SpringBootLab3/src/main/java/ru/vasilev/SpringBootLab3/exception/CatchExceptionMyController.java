package ru.vasilev.SpringBootLab3.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.vasilev.SpringBootLab3.model.Codes;
import ru.vasilev.SpringBootLab3.model.ErrorCodes;
import ru.vasilev.SpringBootLab3.model.ErrorMessages;
import ru.vasilev.SpringBootLab3.model.Responce;
import ru.vasilev.SpringBootLab3.service.ValidationService;

@Slf4j
@Data
@Service
public class CatchExceptionMyController {
    private final ValidationService validationService;
    private String status;

    public Responce requestException(BindingResult bindingResult, String uid, Responce responce) {
        try {
            validationService.isValid(bindingResult);
            validationService.isUnsup(uid);
        } catch (ValidationFailedException e) {
            log.error("Validation error: {}", e.getMessage());
            status = "BAD_REQUEST";
            responce.setCode(Codes.FAILED);
            responce.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            responce.setErrorMessage(ErrorMessages.VALIDATION);
            return responce;
        } catch (UnsupportedCodeException e) {
            log.error("Unsupported error: {}", e.getMessage());
            responce.setCode(Codes.FAILED);
            responce.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            responce.setErrorMessage(ErrorMessages.UNSUPPORTED);
            status = "BAD_REQUEST";
            return responce;
        } catch (Exception e) {
            log.error("Unknown error: {}", e.getMessage());
            responce.setCode(Codes.FAILED);
            responce.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            responce.setErrorMessage(ErrorMessages.UNKNOWN);
            status = "INTERNAL_SERVER_ERROR";
            return responce;
        }
        status = "OK";
        return responce;
    }
}
