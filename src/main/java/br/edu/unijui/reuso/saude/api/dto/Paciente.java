package br.edu.unijui.reuso.saude.api.dto;

import java.util.Objects;

/**
 *
 * @author lorij
 */
public class Paciente {
    private String id;
    private String nome;
    private String documento;

    public Paciente(String id, String nome, String documento) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getDocumento() { return documento; }

    @Override public String toString() {
        return "Paciente{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id);
    }

    @Override public int hashCode() { return Objects.hash(id); }
}
