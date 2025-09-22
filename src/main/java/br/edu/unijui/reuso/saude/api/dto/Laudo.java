package br.edu.unijui.reuso.saude.api.dto;

import java.time.LocalDateTime;

/**
 *
 * @author lorij
 */
public class Laudo {
    private final String consultaId;
    private final String conteudo;
    private final LocalDateTime emitidoEm;

    public Laudo(String consultaId, String conteudo, LocalDateTime emitidoEm) {
        this.consultaId = consultaId;
        this.conteudo = conteudo;
        this.emitidoEm = emitidoEm;
    }

    public String getConsultaId() { return consultaId; }
    public String getConteudo() { return conteudo; }
    public LocalDateTime getEmitidoEm() { return emitidoEm; }

    @Override public String toString() {
        return "Laudo{" +
                "consultaId='" + consultaId + '\'' +
                ", emitidoEm=" + emitidoEm +
                ", conteudo='" + conteudo + '\'' +
                '}';
    }
}
