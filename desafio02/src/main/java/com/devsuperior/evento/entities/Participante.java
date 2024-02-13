package com.devsuperior.evento.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_participante")
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;

    @OneToMany(mappedBy = "id.participante")
    private Set<AtividadeParticipante> eventos = new HashSet<>();

    public Participante() {
    }

    public Participante(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Set<AtividadeParticipante> getEventos() {
        return eventos;
    }

    public List<Atividade> getAtividades() {
        return eventos.stream().map(x -> x.getAtividade()).toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participante that = (Participante) o;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
