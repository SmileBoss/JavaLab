package ru.itis.apiauthjavalabcom.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.apiauthjavalabcom.domain.Role;
import ru.itis.apiauthjavalabcom.repository.RoleRepository;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RoleController {

    private RoleRepository roleRepository;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Role createNewRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }
}
