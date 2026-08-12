package com.dalvan.gerenciadortarefa.entety;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String username;


    @Column(nullable = false, unique=true, length = 255)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private Integer nivel;

    @Column(nullable = false)
    private Integer ponto;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;


    protected Usuario() {

    }

    public Usuario(String nome, String username, String email, String senha) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.nivel = 1;
        this.ponto = 0;
        this.dataCriacao = LocalDateTime.now();
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getNivel() {
        return nivel;
    }

    public Integer getPonto() {
        return ponto;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }


    public void adicionarPonto(int pontos) {

        if(pontos <= 0) {
            throw new IllegalArgumentException("Pontos deve ser positiva!");
        }
        this.ponto += pontos;
    }

    public void subirNivel(int nivel) {
        this.nivel++;
    }
}
