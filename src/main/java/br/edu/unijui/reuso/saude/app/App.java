package br.edu.unijui.reuso.saude.app;

import br.edu.unijui.reuso.saude.componentes.laudo.EmissaoLaudoSimples;
import br.edu.unijui.reuso.saude.componentes.memoria.AgendamentoConsultaEmMemoria;
import br.edu.unijui.reuso.saude.componentes.memoria.CadastroPacienteEmMemoria;
import br.edu.unijui.reuso.saude.componentes.notificacao.ConsoleNotificador;

/**
 *
 * @author lorij
 */
public class App {
    public static void main(String[] args) {
        var sistema = new SistemaSaude(
            new CadastroPacienteEmMemoria(),
            new AgendamentoConsultaEmMemoria(), 
            new EmissaoLaudoSimples(),
            new ConsoleNotificador()
        );
        sistema.executarFluxoDemo();
    }
}
