package io.github.rafaelgoesti.ticketapi.Entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(name = "perfil_usuario")
    @Enumerated(EnumType.STRING)
    private PerfilUsuario perfilUsuario;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Chamado> chamadosCriados;

    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamadosTecnico;

    @Column(name = "criado_em", updatable = false)
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    public Usuario(String nome, String email, String senha, PerfilUsuario perfilUsuario) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfilUsuario = perfilUsuario;
    }

    @PrePersist
    protected void onCreate() {
        this.criadoEm = LocalDateTime.now();
        this.atualizadoEm = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.atualizadoEm = LocalDateTime.now();
    }

    public Usuario(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public PerfilUsuario getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    public List<Chamado> getChamadosCriados() {
        return chamadosCriados;
    }

    public void setChamadosCriados(List<Chamado> chamadosCriados) {
        this.chamadosCriados = chamadosCriados;
    }

    public List<Chamado> getChamadosTecnico() {
        return chamadosTecnico;
    }

    public void setChamadosTecnico(List<Chamado> chamadosTecnico) {
        this.chamadosTecnico = chamadosTecnico;
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
