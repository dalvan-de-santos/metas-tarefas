package com.dalvan.gerenciadortarefa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @GetMapping("/")
    public String testarAplicacao() {
        return "Gerenciador de Tarefas e Metas funcionando!";
    }
}
