package com.dalvan.gerenciadortarefa.controller;


import com.dalvan.gerenciadortarefa.dto.MetaCadastroDto;
import com.dalvan.gerenciadortarefa.dto.MetaDto;
import com.dalvan.gerenciadortarefa.entety.Usuario;
import com.dalvan.gerenciadortarefa.service.MetaService;
import com.dalvan.gerenciadortarefa.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metas")
public class MetaController {
    private final MetaService metaService;
    private final UsuarioService usuarioService;

    public MetaController(MetaService metaService, UsuarioService usuarioService) {
        this.metaService = metaService;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public MetaDto cadastrar(@Valid @RequestBody MetaCadastroDto dados, Authentication authentication) {

        String email = authentication.getName();

        Usuario usuario = usuarioService.buscarPorEmail(email);

        return metaService.cadastrar(dados, usuario);
    }


}
