package ru.vasilev.SpringBootLab4.service;

import org.springframework.stereotype.Service;
import ru.vasilev.SpringBootLab4.model.Responce;

@Service
public interface ModifyResponseService {

    Responce modify(Responce responce);
}
