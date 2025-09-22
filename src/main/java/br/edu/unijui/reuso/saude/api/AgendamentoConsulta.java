package br.edu.unijui.reuso.saude.api;

import br.edu.unijui.reuso.saude.api.dto.Consulta;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author lorij
 */
public interface AgendamentoConsulta {
    Consulta agendar(String pacienteId, LocalDateTime dataHora, String especialidade);
    List<Consulta> listarPorPaciente(String pacienteId);
    Optional<Consulta> buscarPorId(String id);
}
