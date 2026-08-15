package com.dalvan.gerenciadortarefa.dto;

import java.util.Map;

public class ErroDto {
    private int status;
    private String erro;
    private Map<String, String> campos;

    public ErroDto(int status, String erro) {
        this.status = status;
        this.erro = erro;
    }

    public ErroDto(int status, String erro, Map<String, String> campos) {
        this.status = status;
        this.erro = erro;
        this.campos = campos;
    }

    public int getStatus() {
        return status;
    }

    public String getErro() {
        return erro;
    }

    public Map<String, String> getCampo() {
        return campos;
    }


}
