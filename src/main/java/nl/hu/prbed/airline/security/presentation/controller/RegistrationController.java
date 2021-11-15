package nl.hu.prbed.airline.security.presentation.controller;

import nl.hu.prbed.airline.security.application.UserService;
import nl.hu.prbed.airline.security.presentation.dto.Registration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void register(@Validated @RequestBody Registration registration) {
        this.userService.register(registration);
    }
}
