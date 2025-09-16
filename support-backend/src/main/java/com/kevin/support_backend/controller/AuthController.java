package com.kevin.support_backend.controller;

import com.kevin.support_backend.model.User;
import com.kevin.support_backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Optional<User> optionalUser = userService.getUserByUsername(user.getUsername());

        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(401).body("Usuario no encontrado");
        }

        User u = optionalUser.get();
        if (!passwordEncoder.matches(user.getPassword(), u.getPassword())) {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }

        // Construir respuesta segura sin contraseña
        User safeUser = new User();
        safeUser.setId(u.getId());
        safeUser.setUsername(u.getUsername());
        safeUser.setEmail(u.getEmail());
        safeUser.setRole(u.getRole());

        return ResponseEntity.ok(safeUser);
    }
}
