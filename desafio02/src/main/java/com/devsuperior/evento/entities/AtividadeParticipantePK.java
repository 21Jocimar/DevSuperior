package com.devsuperior.evento.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class AtividadeParticipantePK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "atividade_id")
    private Atividade atividade;

    @ManyToOne
    @JoinColumn(name = "participante_id")
    private Participante participante;

    public AtividadeParticipantePK() {
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AtividadeParticipantePK that = (AtividadeParticipantePK) o;

        if (!getAtividade().equals(that.getAtividade())) return false;
        return getParticipante().equals(that.getParticipante());
    }

    @Override
    public int hashCode() {
        int result = getAtividade().hashCode();
        result = 31 * result + getParticipante().hashCode();
        return result;
    }
}
