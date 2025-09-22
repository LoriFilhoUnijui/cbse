package br.edu.unijui.reuso.saude.componentes.notificacao;

import br.edu.unijui.reuso.saude.api.Notificador;
import br.edu.unijui.reuso.saude.api.dto.Laudo;

/**
 *
 * @author lorij
 */
public class ConsoleNotificador implements Notificador {
    @Override
    public void notificarLaudo(Laudo laudo) {
        System.out.println("[NOTIFICACAO] Laudo emitido para consulta " + laudo.getConsultaId() + " em " + laudo.getEmitidoEm());
        System.out.println("Conteudo: " + laudo.getConteudo());
    }
}
