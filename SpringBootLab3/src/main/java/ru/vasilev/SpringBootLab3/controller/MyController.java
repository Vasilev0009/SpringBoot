package ru.vasilev.SpringBootLab3.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vasilev.SpringBootLab3.exception.UnsupportedCodeException;
import ru.vasilev.SpringBootLab3.exception.ValidationFailedException;
import ru.vasilev.SpringBootLab3.model.*;
import jakarta.validation.Valid;
import ru.vasilev.SpringBootLab3.service.ModifyResponseService;
import ru.vasilev.SpringBootLab3.service.ValidationService;
import ru.vasilev.SpringBootLab3.util.DateTimeUtil;
import java.util.Date;

@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;

    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifyOperationUidResponseService") ModifyResponseService modifyResponseService) {
        this.validationService = validationService;
        this.modifyResponseService =modifyResponseService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Responce> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult){
        log.info("request: {}", request);

        Responce responce = Responce.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();

        log.info("Generated response: {}", responce);

        try {
            validationService.isValid(bindingResult);
            validationService.isUnsup(request.getUid());
        } catch (ValidationFailedException e){
            log.error("Validation error: {}", e.getMessage());
            responce.setCode(Codes.FAILED);
            responce.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            responce.setErrorMessage(ErrorMessages.VALIDATION);
            return new ResponseEntity<>(responce, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException e){
            log.error("Unsupported error: {}", e.getMessage());
            responce.setCode(Codes.FAILED);
            responce.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            responce.setErrorMessage(ErrorMessages.UNSUPPORTED);
            return new ResponseEntity<>(responce, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Unknown error: {}", e.getMessage());
            responce.setCode(Codes.FAILED);
            responce.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            responce.setErrorMessage(ErrorMessages.UNKNOWN);
            return new ResponseEntity<>(responce, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        modifyResponseService.modify(responce);
        log.info("Modified response: {}", responce);
        return new ResponseEntity<>(responce, HttpStatus.OK);
    }
}
