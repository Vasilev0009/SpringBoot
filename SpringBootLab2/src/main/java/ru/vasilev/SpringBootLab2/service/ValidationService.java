package ru.vasilev.SpringBootLab2.service;

import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Service;
import ru.vasilev.SpringBootLab2.exception.UnsupportedCodeException;
import ru.vasilev.SpringBootLab2.exception.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
    void isUnsup(String uid) throws UnsupportedCodeException;
}
