package ru.vasilev.SpringBootLab3.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.vasilev.SpringBootLab3.model.Request;

import static ru.vasilev.SpringBootLab3.model.Systems.SERVICE1;

@Service
@Qualifier("ModifySystemNameRequestService")
public class ModifySystemNameRequestService implements ModifyRequestService {
    @Override
    public void modify(Request request) {
        request.setSystemName(SERVICE1);

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        new RestTemplate().exchange("http://localhost:8084/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>() {
                });
    }
}