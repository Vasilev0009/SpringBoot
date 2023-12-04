package ru.vasilev.SpringBootLab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vasilev.SpringBootLab2.exception.RequestValidationService;
import ru.vasilev.SpringBootLab2.exception.UnsupportedCodeException;
import ru.vasilev.SpringBootLab2.exception.ValidationFailedException;
import ru.vasilev.SpringBootLab2.model.Request;
import ru.vasilev.SpringBootLab2.model.Responce;
import org.springframework.http.ResponseEntity;
import ru.vasilev.SpringBootLab2.service.ValidationService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class MyController {

    private final RequestValidationService validationService;

    @Autowired
    public MyController(RequestValidationService validationService){
        this.validationService = validationService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Responce> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy'  'HH:mm:ss");

        Responce responce = Responce.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(simpleDateFormat.format(new Date()))
                .code("succes")
                .errorCode("")
                .errorMessage("")
                .build();
        try {
            validationService.isValid(bindingResult);
            validationService.isUnsup(request.getUid());
        } catch (ValidationFailedException e){
            responce.setCode("Failed");
            responce.setErrorCode("ValidationExeption");
            responce.setErrorMessage("Error: " + e);
            return new ResponseEntity<>(responce, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException e){
            responce.setCode("Failed");
            responce.setErrorCode("UnsupportedCodeException");
            responce.setErrorMessage("Error: " + e);
            return new ResponseEntity<>(responce, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            responce.setCode("Filed");
            responce.setErrorCode("UnknownException");
            responce.setErrorMessage("Произошла непредвиденная ошибка");
            return new ResponseEntity<>(responce, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responce, HttpStatus.OK);
    }
}
