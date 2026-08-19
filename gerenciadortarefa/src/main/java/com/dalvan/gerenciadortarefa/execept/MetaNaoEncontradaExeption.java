package com.dalvan.gerenciadortarefa.execept;

public class MetaNaoEncontradaExeption extends RuntimeException {
    public MetaNaoEncontradaExeption(){
        super("Meta não encontrada");
    }
}
