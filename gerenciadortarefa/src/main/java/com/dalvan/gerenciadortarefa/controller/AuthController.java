package com.dalvan.gerenciadortarefa.controller;

import com.dalvan.gerenciadortarefa.dto.LoginResponseDto;
import com.dalvan.gerenciadortarefa.dto.UsuarioLoginDto;
import com.dalvan.gerenciadortarefa.entety.Usuario;
import com.dalvan.gerenciadortarefa.service.AuthService;
import com.dalvan.gerenciadortarefa.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponseDto login(@Valid @RequestBody UsuarioLoginDto dados) {
        String token = authService.login(dados);
        return new LoginResponseDto(token);
    }
}
