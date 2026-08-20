package com.dalvan.gerenciadortarefa.controller;


import com.dalvan.gerenciadortarefa.dto.AtualizarMetaDto;
import com.dalvan.gerenciadortarefa.dto.MetaCadastroDto;
import com.dalvan.gerenciadortarefa.dto.MetaDto;
import com.dalvan.gerenciadortarefa.entity.Usuario;
import com.dalvan.gerenciadortarefa.service.MetaService;
import com.dalvan.gerenciadortarefa.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<MetaDto> listar(Authentication authentication) {
        String email = authentication.getName();
        Usuario usuario = usuarioService.buscarPorEmail(email);

        return metaService.listarMetaUsuario(usuario);
    }

    @GetMapping("/{id}")
    public MetaDto buscarPorId(@PathVariable Long id, Authentication authentication) {
        String email = authentication.getName();

        Usuario usuario = usuarioService.buscarPorEmail(email);

        return metaService.buscarIdAndUsuario(id, usuario);
    }

    @PutMapping("/{id}")
    public MetaDto atualizar(@PathVariable Long id, @Valid @RequestBody AtualizarMetaDto dados, Authentication authentication) {
        String email = authentication.getName();
        Usuario usuario = usuarioService.buscarPorEmail(email);

        return metaService.atualizar(id, dados, usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id, Authentication authentication) {
        String email = authentication.getName();
        Usuario usuario = usuarioService.buscarPorEmail(email);

        metaService.deletar(id, usuario);

        return ResponseEntity.noContent().build();
    }

}
