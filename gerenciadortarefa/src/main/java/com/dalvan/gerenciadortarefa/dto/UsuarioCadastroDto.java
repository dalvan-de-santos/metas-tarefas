package com.dalvan.gerenciadortarefa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioCadastroDto {

    @NotBlank(message = "O nome  é obrigatorio")
    private String nome;

    @NotBlank(message = "Username é obrigatorio")
    private String username;

    @NotBlank(message = "O email é obrigatorio")
    @Email(message = "Formato de email invalido")
    private String email;

    @NotBlank(message = "A senha é obrigatorio")
    @Size(min = 8, message = "A senha deve ter no minimo 8 caractere")
    private String senha;

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
}
