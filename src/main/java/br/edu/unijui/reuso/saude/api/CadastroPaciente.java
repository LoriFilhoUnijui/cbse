package br.edu.unijui.reuso.saude.api;

import br.edu.unijui.reuso.saude.api.dto.Paciente;
import java.util.Optional;

/**
 *
 * @author lorij
 */
public interface CadastroPaciente {
    Paciente cadastrar(Paciente paciente);
    Optional<Paciente> buscarPorId(String id);
}
