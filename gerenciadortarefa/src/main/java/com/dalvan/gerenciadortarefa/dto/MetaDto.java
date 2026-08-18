package com.dalvan.gerenciadortarefa.dto;

import com.dalvan.gerenciadortarefa.enums.StatusMeta;
import com.dalvan.gerenciadortarefa.enums.TipoMeta;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MetaDto {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate prazo;
    private TipoMeta tipo;
    private StatusMeta status;
    private LocalDateTime dataCriacao;


    public MetaDto(Long id, String titulo, String descricao, LocalDate prazo, TipoMeta tipo, StatusMeta status, LocalDateTime dataCriacao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.tipo = tipo;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public TipoMeta getTipo() {
        return tipo;
    }

    public StatusMeta getStatus() {
        return status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
