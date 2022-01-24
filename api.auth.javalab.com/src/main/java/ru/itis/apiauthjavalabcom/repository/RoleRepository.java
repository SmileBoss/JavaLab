package ru.itis.apiauthjavalabcom.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.apiauthjavalabcom.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
