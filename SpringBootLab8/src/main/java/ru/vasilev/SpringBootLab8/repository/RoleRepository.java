package ru.vasilev.SpringBootLab8.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.vasilev.SpringBootLab8.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
