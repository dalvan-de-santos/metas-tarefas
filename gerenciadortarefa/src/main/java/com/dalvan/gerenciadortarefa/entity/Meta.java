package com.dalvan.gerenciadortarefa.entity;

import com.dalvan.gerenciadortarefa.enums.StatusMeta;
import com.dalvan.gerenciadortarefa.enums.TipoMeta;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "metas")
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String titulo;

    @Column(length = 500)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private TipoMeta tipo;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private StatusMeta status;

    @Column(nullable = false)
    private LocalDateTime dataInicio;

    @Column(nullable = false)
    private LocalDate prazo;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    protected Meta() {

    }

    public Meta(String titulo, String descricao, TipoMeta tipo, Usuario usuario, LocalDate prazo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.usuario = usuario;
        this.prazo = prazo;

        this.status = StatusMeta.EM_ANDAMENTO;
        this.dataInicio = LocalDateTime.now();
        this.dataCriacao = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }


    public TipoMeta getTipo() {
        return tipo;
    }

    public StatusMeta getStatus() {
        return status;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTipo(TipoMeta tipo) {
        this.tipo = tipo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }


}
