package com.dalvan.gerenciadortarefa.entity;

import com.dalvan.gerenciadortarefa.enums.StatusTarefa;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tarefas")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(length = 255)
    private String descricao;

    @Column(nullable = false)
    private int numeroDia;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private StatusTarefa status;

    @Column(nullable = false)
    private LocalDate dataPrevista;

    @Column(nullable = true)
    private LocalDateTime dataConclusao;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "meta_id", nullable = false)
    private Meta meta;

    protected Tarefa() {}


    public Tarefa(String titulo, String descricao, LocalDate dataPrevista, Meta meta) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPrevista = dataPrevista;

        this.meta = meta;
        this.numeroDia = 1;
        this.status = StatusTarefa.NAO_CONCLUIDA;
        this.dataCriacao = LocalDateTime.now();
    }

    public void concluirTarefa() {
        this.status = StatusTarefa.CONCLUIDA;
        this.dataConclusao = LocalDateTime.now();
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData_prevista(LocalDate data_prevista) {
        this.dataPrevista = data_prevista;
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

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Meta getMeta() {
        return meta;
    }
}
