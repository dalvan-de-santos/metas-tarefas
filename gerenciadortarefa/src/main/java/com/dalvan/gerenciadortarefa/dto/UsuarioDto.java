package com.dalvan.gerenciadortarefa.dto;

public class UsuarioDto {
    private String nome;
    private String username;
    private String email;
    private int nivel;
    private int pontos;


    public UsuarioDto(String nome, String username, String email, int nivel, int pontos) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.nivel = nivel;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
