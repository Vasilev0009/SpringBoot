package ru.vasilev.SpringBootLab4.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.vasilev.SpringBootLab4.exception.UnsupportedCodeException;
import ru.vasilev.SpringBootLab4.exception.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
    void isUnsup(String uid) throws UnsupportedCodeException;
}
