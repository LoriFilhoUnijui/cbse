package br.edu.unijui.reuso.saude.app;

import br.edu.unijui.reuso.saude.api.dto.Laudo;
import br.edu.unijui.reuso.saude.api.dto.Paciente;
import br.edu.unijui.reuso.saude.api.Notificador;
import br.edu.unijui.reuso.saude.api.EmissaoLaudo;
import br.edu.unijui.reuso.saude.api.AgendamentoConsulta;
import br.edu.unijui.reuso.saude.api.CadastroPaciente;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author lorij
 */
public class SistemaSaude {
    private final CadastroPaciente cadastro;
    private final AgendamentoConsulta agendamento;
    private final EmissaoLaudo emissaoLaudo;
    private final Notificador notificador;

    
    public SistemaSaude(CadastroPaciente cadastro, AgendamentoConsulta agendamento, EmissaoLaudo emissaoLaudo, Notificador notificador) {
        this.cadastro = cadastro;
        this.agendamento = agendamento;
        this.emissaoLaudo = emissaoLaudo;
        this.notificador = notificador;
    }

    public Laudo executarFluxoDemo() {
        Paciente p = new Paciente(UUID.randomUUID().toString(), "Lori Machado Abacate da Silva", "000.111.666-33");
        cadastro.cadastrar(p);

        var consulta = agendamento.agendar(p.getId(), LocalDateTime.now().plusDays(1), "Clínico Geral");
        var laudo = emissaoLaudo.emitir(consulta, "Paciente em bom estado clínico.");

        notificador.notificarLaudo(laudo);

        System.out.println(p);
        System.out.println(consulta);
        System.out.println(laudo);

        return laudo;
    }
}
