package com.dalvan.gerenciadortarefa.execept;

public class CredenciaisIvalidasExeception extends  RuntimeException{
    public CredenciaisIvalidasExeception(){
        super("E-mail ou senha invalido");
    }
}
