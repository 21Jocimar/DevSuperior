package com.devsuperior.evento.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_atividade_participante")
public class AtividadeParticipante {

    @EmbeddedId
    private AtividadeParticipantePK id =new AtividadeParticipantePK();

    public AtividadeParticipante() {
    }

    public AtividadeParticipante(Atividade atividade, Participante participante) {
        id.setAtividade(atividade);
        id.setParticipante(participante);
    }

    public Atividade getAtividade() {
        return id.getAtividade();
    }

    public void setAtividade(Atividade atividade) {
        id.setAtividade(atividade);
    }

    public Participante getParticipante() {
        return id.getParticipante();
    }

    public void setParticipante(Participante participante) {
        id.setParticipante(participante);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AtividadeParticipante that = (AtividadeParticipante) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
