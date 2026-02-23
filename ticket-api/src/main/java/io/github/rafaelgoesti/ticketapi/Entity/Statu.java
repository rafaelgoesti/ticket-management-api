package io.github.rafaelgoesti.ticketapi.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Statu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "status")
    private List<Chamado> chamadoStatu;

    public Statu(String nome) {
        this.nome = nome;
    }

    public Statu(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Chamado> getChamadoStatu() {
        return chamadoStatu;
    }

    public void setChamadoStatu(List<Chamado> chamadoStatu) {
        this.chamadoStatu = chamadoStatu;
    }
}
