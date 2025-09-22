package br.edu.unijui.reuso.saude.api.dto;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author lorij
 */
public class Consulta {
    private String id;
    private String pacienteId;
    private LocalDateTime dataHora;
    private String especialidade;

    public Consulta(String id, String pacienteId, LocalDateTime dataHora, String especialidade) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.dataHora = dataHora;
        this.especialidade = especialidade;
    }

    public String getId() { return id; }
    public String getPacienteId() { return pacienteId; }
    public LocalDateTime getDataHora() { return dataHora; }
    public String getEspecialidade() { return especialidade; }

    @Override public String toString() {
        return "Consulta{" +
                "id='" + id + '\'' +
                ", pacienteId='" + pacienteId + '\'' +
                ", dataHora=" + dataHora +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consulta consulta = (Consulta) o;
        return Objects.equals(id, consulta.id);
    }

    @Override public int hashCode() { return Objects.hash(id); }
}
