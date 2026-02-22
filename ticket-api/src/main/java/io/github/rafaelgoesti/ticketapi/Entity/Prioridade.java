package io.github.rafaelgoesti.ticketapi.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Prioridade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "prioridade")
    private List<Chamado> chamadoPrioridade;

    public Prioridade(String nome, List<Chamado> chamadoPrioridade) {
        this.nome = nome;
        this.chamadoPrioridade = chamadoPrioridade;
    }

    public Prioridade(){
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

    public List<Chamado> getChamadoPrioridade() {
        return chamadoPrioridade;
    }

    public void setChamadoPrioridade(List<Chamado> chamadoPrioridade) {
        this.chamadoPrioridade = chamadoPrioridade;
    }
}