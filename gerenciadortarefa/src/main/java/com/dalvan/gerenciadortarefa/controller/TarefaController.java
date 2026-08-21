package com.dalvan.gerenciadortarefa.controller;

import com.dalvan.gerenciadortarefa.dto.TarefaCadastroDto;
import com.dalvan.gerenciadortarefa.dto.TarefaDto;
import com.dalvan.gerenciadortarefa.entity.Meta;
import com.dalvan.gerenciadortarefa.entity.Tarefa;
import com.dalvan.gerenciadortarefa.entity.Usuario;
import com.dalvan.gerenciadortarefa.execept.MetaNaoEncontradaExeption;
import com.dalvan.gerenciadortarefa.repository.MetaRepository;
import com.dalvan.gerenciadortarefa.repository.UsuarioRepository;
import com.dalvan.gerenciadortarefa.service.TarefaService;
import com.dalvan.gerenciadortarefa.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    private final TarefaService tarefaService;
    private final MetaRepository metaRepository;
    private final UsuarioService usuarioService;

    public TarefaController(TarefaService tarefaSrvice,  MetaRepository metaRepository, UsuarioService usuarioService) {
        this.tarefaService = tarefaSrvice;
        this.metaRepository = metaRepository;
        this.usuarioService = usuarioService;

    }

    @PostMapping("/{idMeta}")
    public TarefaDto salvar(@PathVariable Long idMeta, @Valid @RequestBody TarefaCadastroDto dados, Authentication authentication){
        String email = authentication.getName();
        Usuario usuario = usuarioService.buscarPorEmail(email);

        Meta meta = metaRepository.findByIdAndUsuario(idMeta, usuario)
                .orElseThrow(() -> new MetaNaoEncontradaExeption());


        return tarefaService.cadastrar(dados, meta);
    }
}
