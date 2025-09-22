package br.edu.unijui.reuso.saude;

import br.edu.unijui.reuso.saude.api.Notificador;
import br.edu.unijui.reuso.saude.api.dto.Paciente;
import br.edu.unijui.reuso.saude.api.dto.Laudo;
import br.edu.unijui.reuso.saude.app.SistemaSaude;
import br.edu.unijui.reuso.saude.componentes.laudo.EmissaoLaudoSimples;
import br.edu.unijui.reuso.saude.componentes.memoria.AgendamentoConsultaComConflito;
import br.edu.unijui.reuso.saude.componentes.memoria.AgendamentoConsultaEmMemoria;
import br.edu.unijui.reuso.saude.componentes.memoria.CadastroPacienteEmMemoria;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lorij
 */
public class AppTest {

    @Test
    void fluxoBasicoFuncionaENotifica() {
        var cadastro = new CadastroPacienteEmMemoria();
        var agenda = new AgendamentoConsultaEmMemoria();
        var laudo = new EmissaoLaudoSimples();

        AtomicBoolean notificado = new AtomicBoolean(false);
        Notificador fake = new Notificador() {
            @Override public void notificarLaudo(Laudo l) { notificado.set(true); }
        };

        var sistema = new SistemaSaude(cadastro, agenda, laudo, fake);
        var resultado = sistema.executarFluxoDemo();
        assertNotNull(resultado);
        assertTrue(notificado.get(), "Deveria notificar após emissão do laudo");
    }

    @Test
    void agendamentoComConflitoDeveFalhar() {
        var agenda = new AgendamentoConsultaComConflito();
        var cadastro = new CadastroPacienteEmMemoria();
        var laudo = new EmissaoLaudoSimples();

        var p = cadastro.cadastrar(new Paciente(UUID.randomUUID().toString(), "Teste", "123"));
        var data = LocalDateTime.now().plusDays(1).withNano(0);

        agenda.agendar(p.getId(), data, "Clínico");

        assertThrows(IllegalArgumentException.class, () ->
            agenda.agendar(p.getId(), data, "Clínico"),
            "Deveria lançar exceção em caso de conflito de horário para o mesmo paciente"
        );
    }
}
