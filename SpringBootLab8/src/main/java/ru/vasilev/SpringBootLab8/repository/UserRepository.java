package ru.vasilev.SpringBootLab8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vasilev.SpringBootLab8.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}