package ru.vasilev.SpringBootLab3.service;

import org.springframework.stereotype.Service;
import ru.vasilev.SpringBootLab3.model.Request;

@Service
public interface ModifyRequestService {
    void modify (Request request);
}
