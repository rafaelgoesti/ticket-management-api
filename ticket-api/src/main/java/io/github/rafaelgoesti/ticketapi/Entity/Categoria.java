package io.github.rafaelgoesti.ticketapi.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Chamado> chamadoCategoria;

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria(){

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

    public List<Chamado> getChamadoCategoria() {
        return chamadoCategoria;
    }

    public void setChamadoCategoria(List<Chamado> chamadoCategoria) {
        this.chamadoCategoria = chamadoCategoria;
    }
}
