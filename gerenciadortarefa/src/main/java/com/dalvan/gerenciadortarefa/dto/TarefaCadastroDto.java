package com.dalvan.gerenciadortarefa.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TarefaCadastroDto {

    @NotBlank(message = "O titulo é obrigatorio")
    @Size(max = 120, message = "O titulo deve ter no maximo 120 caratcter")
    private String titulo;

    @Size(max = 500, message = "A descrição deve ter no maximo 500 caracter")
    private String descricao;

    @NotNull(message = "A data prevista é obrigatoria")
    @FutureOrPresent(message = "A data prevista não pode estar no passado")
    private LocalDate dataPrevista;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(LocalDate dataPrevista) {
        this.dataPrevista = dataPrevista;
    }
}
