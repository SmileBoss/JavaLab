package ru.itis.apiauthjavalabcom.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.apiauthjavalabcom.domain.Role;
import ru.itis.apiauthjavalabcom.domain.User;
import ru.itis.apiauthjavalabcom.repository.RoleRepository;
import ru.itis.apiauthjavalabcom.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
//@RequiredArgsConstructor
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public User createNewUser(User user) {
        Role role = roleRepository.findById("USER").get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(getEncodedPassword(user.getPassword()));
        return userRepository.save(user);
    }

    private String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
