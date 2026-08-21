package com.dalvan.gerenciadortarefa.dto;

import com.dalvan.gerenciadortarefa.enums.StatusTarefa;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TarefaDto {
    private Long id;
    private String titulo;
    private String descricao;
    private int numeroDia;
    private StatusTarefa status;
    private LocalDateTime dataCriacao;
    private LocalDate dataPrevista;

    public TarefaDto(Long id, String titulo, String descricao, int numeroDia, StatusTarefa status, LocalDateTime dataCriacao, LocalDate dataPrevista) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.numeroDia = numeroDia;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.dataPrevista = dataPrevista;
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

    public int getNumeroDia() {
        return numeroDia;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }
}
