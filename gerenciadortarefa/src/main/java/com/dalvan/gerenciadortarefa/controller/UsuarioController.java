package com.dalvan.gerenciadortarefa.controller;

import com.dalvan.gerenciadortarefa.dto.UsuarioCadastroDto;
import com.dalvan.gerenciadortarefa.dto.UsuarioDto;
import com.dalvan.gerenciadortarefa.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioDto> listarUsuarios() {
        return usuarioService.findAll();
    }


    @GetMapping("/{id}")
    public UsuarioDto encontrar(@PathVariable Long id){
        return usuarioService.findById(id);


    }

    @PostMapping
    public UsuarioDto salvar(@Valid @RequestBody UsuarioCadastroDto dto){
        UsuarioDto usuarioDto = usuarioService.cadastrar(dto);
        return usuarioDto;
    }
}
