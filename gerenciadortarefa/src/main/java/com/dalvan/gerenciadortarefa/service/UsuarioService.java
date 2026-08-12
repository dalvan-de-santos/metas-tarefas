package com.dalvan.gerenciadortarefa.service;

import com.dalvan.gerenciadortarefa.dto.UsuarioCadastroDto;
import com.dalvan.gerenciadortarefa.dto.UsuarioDto;
import com.dalvan.gerenciadortarefa.entety.Usuario;
import com.dalvan.gerenciadortarefa.execept.UsuarioNaoEncontradoExeception;
import com.dalvan.gerenciadortarefa.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;


    public UsuarioService(UsuarioRepository usuarioRepository,  PasswordEncoder passwordEncoder ) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioDto cadastrar(UsuarioCadastroDto dados) {

        if(usuarioRepository.existsByEmail(dados.getEmail())) {
            throw new RuntimeException("Email ja cadastrado");
        }

        String senhaHash = passwordEncoder.encode(dados.getSenha());

        Usuario usuario = new Usuario(
                dados.getNome(),
                dados.getUsername(),
                dados.getEmail(),
                senhaHash
        );

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new UsuarioDto(
                usuarioSalvo.getNome(),
                usuarioSalvo.getUsername(),
                usuarioSalvo.getEmail(),
                usuario.getNivel(),
                usuario.getPonto()
        );
    }

    public UsuarioDto findById(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(UsuarioNaoEncontradoExeception::new);

        UsuarioDto usuarioDto = new UsuarioDto(
                usuario.getNome(),
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getNivel(),
                usuario.getPonto());




        return usuarioDto;

    }

    public List<UsuarioDto> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDto> usuarioDtos = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            UsuarioDto usuarioDto = new UsuarioDto(
                    usuario.getNome(),
                    usuario.getUsername(),
                    usuario.getEmail(),
                    usuario.getNivel(),
                    usuario.getPonto()
            );
            usuarioDtos.add(usuarioDto);
        }
        return usuarioDtos;
    }
}
