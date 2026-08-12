package com.dalvan.gerenciadortarefa.execept;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNaoEncontradoExeception extends RuntimeException {

    public UsuarioNaoEncontradoExeception() {
        super("Usuario nao encontrado");
    }
}
