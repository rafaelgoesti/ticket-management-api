package io.github.rafaelgoesti.ticketapi.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "criado_por_usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "tecnico_responsavel_id")
    private Usuario tecnico;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Statu status;

    @ManyToOne
    @JoinColumn(name = "prioridade_id")
    private Prioridade prioridade;

    @Column(name = "aberto_em")
    private LocalDateTime abertoEm;

    @Column(name = "fechado_em")
    private LocalDateTime fechadoEm;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    public Chamado(String titulo, String descricao, Usuario usuario, Usuario tecnico,
                   Categoria categoria, Statu status, Prioridade prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.usuario = usuario;
        this.tecnico = tecnico;
        this.categoria = categoria;
        this.status = status;
        this.prioridade = prioridade;
    }

    public Chamado(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getTecnico() {
        return tecnico;
    }

    public void setTecnico(Usuario tecnico) {
        this.tecnico = tecnico;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Statu getStatus() {
        return status;
    }

    public void setStatus(Statu status) {
        this.status = status;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public LocalDateTime getAbertoEm() {
        return abertoEm;
    }

    public void setAbertoEm(LocalDateTime abertoEm) {
        this.abertoEm = abertoEm;
    }

    public LocalDateTime getFechadoEm() {
        return fechadoEm;
    }

    public void setFechadoEm(LocalDateTime fechadoEm) {
        this.fechadoEm = fechadoEm;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
}
