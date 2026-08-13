package com.dalvan.gerenciadortarefa.execept;

public class EmailJaCadastradoException extends RuntimeException {
    public EmailJaCadastradoException(){
        super("Email ja cadastrado");
    }
}
