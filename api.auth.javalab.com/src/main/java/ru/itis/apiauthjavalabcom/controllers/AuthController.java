package ru.itis.apiauthjavalabcom.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.apiauthjavalabcom.domain.AuthRequest;
import ru.itis.apiauthjavalabcom.domain.AuthResponse;
import ru.itis.apiauthjavalabcom.domain.User;
//import ru.itis.apiauthjavalabcom.domain.UserEvent;
import ru.itis.apiauthjavalabcom.security.JwtUserDetailService;
import ru.itis.apiauthjavalabcom.services.UserService;

import java.security.Principal;
//import org.springframework.cloud.stream.function.StreamBridge;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final JwtUserDetailService userDetailService;
    private final UserService userService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) throws Exception {
        return userDetailService.createJwtToken(request);
    }

    @PostMapping("/register")
    public User registerNewUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }
}
