package ru.vasilev.SpringBootLab3.service;

import org.springframework.stereotype.Service;
import ru.vasilev.SpringBootLab3.model.Responce;

@Service
public interface ModifyResponseService {

    Responce modify(Responce responce);
}
