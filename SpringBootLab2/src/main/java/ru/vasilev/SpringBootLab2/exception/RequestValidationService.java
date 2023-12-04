package ru.vasilev.SpringBootLab2.exception;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.vasilev.SpringBootLab2.service.ValidationService;

@Service
public class RequestValidationService implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult.getFieldError().getDefaultMessage().toString());
        }
    }
    public void isUnsup(String uid) throws UnsupportedCodeException {
        if (uid.equals("123")){
            throw new UnsupportedCodeException("Данный uid не поддерживается");
        }
    }
}
