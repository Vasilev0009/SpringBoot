package ru.vasilev.SpringBootLab8.service;

import ru.vasilev.SpringBootLab8.dto.UserDto;
import ru.vasilev.SpringBootLab8.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
