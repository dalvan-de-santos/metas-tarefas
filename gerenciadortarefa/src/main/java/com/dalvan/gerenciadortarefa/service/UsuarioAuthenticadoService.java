package com.dalvan.gerenciadortarefa.service;

import com.dalvan.gerenciadortarefa.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioAuthenticadoService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioAuthenticadoService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


}
