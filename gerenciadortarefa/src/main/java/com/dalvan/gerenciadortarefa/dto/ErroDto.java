package com.dalvan.gerenciadortarefa.dto;

public class ErroDto {
    private int status;
    private String erro;

    public ErroDto(int status, String erro) {
        this.status = status;
        this.erro = erro;
    }

    public int getStatus() {
        return status;
    }

    public String getErro() {
        return erro;
    }


}
