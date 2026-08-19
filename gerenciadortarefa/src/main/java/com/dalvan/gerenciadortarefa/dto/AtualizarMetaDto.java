package com.dalvan.gerenciadortarefa.dto;

import com.dalvan.gerenciadortarefa.enums.TipoMeta;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class AtualizarMetaDto {
    @NotBlank(message = "O titulo é obrigatorio")
    @Size(max = 120, message = "O titulo deve ter no maximo 120 caracter")
    private String titulo;
    @Size(max = 500, message = "A descrição deve ter no maximo 500n caracterer")
    private String descricao;

    @NotNull(message = "O tipo é obrigatorio")
    private TipoMeta tipo;

    @NotNull(message = "O prazo é obrigatorio")
    @FutureOrPresent(message = "O prazp não pode ta no passado")
    private LocalDate prazo;

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

    public TipoMeta getTipo() {
        return tipo;
    }

    public void setTipo(TipoMeta tipo) {
        this.tipo = tipo;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }
}
