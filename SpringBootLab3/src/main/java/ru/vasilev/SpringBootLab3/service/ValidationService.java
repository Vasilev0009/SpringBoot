package ru.vasilev.SpringBootLab3.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.vasilev.SpringBootLab3.exception.UnsupportedCodeException;
import ru.vasilev.SpringBootLab3.exception.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
    void isUnsup(String uid) throws UnsupportedCodeException;
}
