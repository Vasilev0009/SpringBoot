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
import ru.vasilev.SpringBootLab3.exception.CatchExceptionMyController;
import ru.vasilev.SpringBootLab3.model.*;
import jakarta.validation.Valid;
import ru.vasilev.SpringBootLab3.service.*;
import ru.vasilev.SpringBootLab3.util.DateTimeUtil;
import java.util.Date;

@Slf4j
@RestController
public class MyController {

    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifyRequestService;
    private final AnnualBonusService annualBonusService;
    private final CatchExceptionMyController catchExceptionMyController;

    @Autowired
    public MyController(CatchExceptionMyController catchExceptionMyController, AnnualBonusService annualBonusService,
                        @Qualifier("ModifyOperationUidResponseService") ModifyResponseService modifyResponseService,
                        @Qualifier("ModifySystemTimeRequestService") ModifyRequestService modifyRequestService) {
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
        this.catchExceptionMyController = catchExceptionMyController;
        this.annualBonusService = annualBonusService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Responce> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult){
        log.info("request: {}", request);
                // Рассчет премиии
        double Bonus = annualBonusService.calculate(request.getPosition(), request.getSalary(), request.getBonus(), request.getWorkDays());

        Responce responce = Responce.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .annualBonus(Bonus)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();

        log.info("Generated response: {}", responce);

        responce = catchExceptionMyController.requestException(bindingResult,request.getUid(),responce);   // Проверка request на ошибки
//        responce.setAnnualBonus(Bonus); //Записывает в responce расчитанную премию

        modifyResponseService.modify(responce);
        log.info("Modified response: {}", responce);
        modifyRequestService.modify(request);
        log.info("Modified request: {}", request);
        return new ResponseEntity<>(responce, HttpStatus.valueOf(catchExceptionMyController.getStatus()));
    }
}
