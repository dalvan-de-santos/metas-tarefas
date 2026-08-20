package com.dalvan.gerenciadortarefa.controller;

import com.dalvan.gerenciadortarefa.dto.LoginResponseDto;
import com.dalvan.gerenciadortarefa.dto.UsuarioLoginDto;
import com.dalvan.gerenciadortarefa.entity.Usuario;
import com.dalvan.gerenciadortarefa.service.AuthService;
import com.dalvan.gerenciadortarefa.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final UsuarioService usuarioService;

    public AuthController(AuthService authService, UsuarioService usuarioService) {

        this.authService = authService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public LoginResponseDto login(@Valid @RequestBody UsuarioLoginDto dados) {
        String token = authService.login(dados);
        return new LoginResponseDto(token);
    }

    @GetMapping("/me")
    public String usuarioLogado(Authentication authentication) {
        String email = authentication.getName();

        Usuario usuario = usuarioService.buscarPorEmail(email);

        return email;
    }
}
