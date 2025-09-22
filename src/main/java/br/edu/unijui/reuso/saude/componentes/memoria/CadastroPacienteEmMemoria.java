package br.edu.unijui.reuso.saude.componentes.memoria;

import br.edu.unijui.reuso.saude.api.CadastroPaciente;
import br.edu.unijui.reuso.saude.api.dto.Paciente;

import java.util.*;

/**
 *
 * @author lorij
 */
public class CadastroPacienteEmMemoria implements CadastroPaciente {
    private final Map<String, Paciente> banco = new HashMap<>();

    @Override
    public Paciente cadastrar(Paciente paciente) {
        banco.put(paciente.getId(), paciente);
        return paciente;
    }

    @Override
    public Optional<Paciente> buscarPorId(String id) {
        return Optional.ofNullable(banco.get(id));
    }
}
