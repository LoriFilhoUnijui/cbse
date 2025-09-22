package br.edu.unijui.reuso.saude.componentes.memoria;

import br.edu.unijui.reuso.saude.api.AgendamentoConsulta;
import br.edu.unijui.reuso.saude.api.dto.Consulta;

import java.time.LocalDateTime;
import java.util.*;

/**
 *
 * @author lorij
 */
public class AgendamentoConsultaEmMemoria implements AgendamentoConsulta {
    private final Map<String, Consulta> banco = new HashMap<>();

    @Override
    public Consulta agendar(String pacienteId, LocalDateTime dataHora, String especialidade) {
        String id = UUID.randomUUID().toString();
        Consulta c = new Consulta(id, pacienteId, dataHora, especialidade);
        banco.put(id, c);
        return c;
    }

    @Override
    public List<Consulta> listarPorPaciente(String pacienteId) {
        List<Consulta> list = new ArrayList<>();
        for (Consulta c : banco.values()) {
            if (Objects.equals(c.getPacienteId(), pacienteId)) list.add(c);
        }
        return list;
    }

    @Override
    public Optional<Consulta> buscarPorId(String id) {
        return Optional.ofNullable(banco.get(id));
    }
}
