package com.dalvan.gerenciadortarefa.service;

import com.dalvan.gerenciadortarefa.entety.Usuario;
import com.dalvan.gerenciadortarefa.execept.UsuarioNaoEncontradoExeception;
import com.dalvan.gerenciadortarefa.repository.UsuarioRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioAuthenticadoService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioAuthenticadoService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


}
