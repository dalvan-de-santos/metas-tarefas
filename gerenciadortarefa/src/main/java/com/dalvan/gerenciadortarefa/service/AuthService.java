package com.dalvan.gerenciadortarefa.service;

import com.dalvan.gerenciadortarefa.dto.UsuarioLoginDto;
import com.dalvan.gerenciadortarefa.entety.Usuario;
import com.dalvan.gerenciadortarefa.execept.CredenciaisIvalidasExeception;
import com.dalvan.gerenciadortarefa.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.undo.CannotRedoException;

@Service
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String login(UsuarioLoginDto dados) {
        Usuario usuario = usuarioRepository.findByEmail(dados.getEmail())
                .orElseThrow(CredenciaisIvalidasExeception::new);

        Boolean senhaCorrecta = passwordEncoder.matches(dados.getSenha(), usuario.getSenha());

        if(!senhaCorrecta){
            throw new CredenciaisIvalidasExeception();
        }

        return jwtService.gerarToken(usuario.getEmail());
    }
}
