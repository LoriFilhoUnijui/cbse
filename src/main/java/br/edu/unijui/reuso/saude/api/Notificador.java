package br.edu.unijui.reuso.saude.api;

import br.edu.unijui.reuso.saude.api.dto.Laudo;

/**
 *
 * @author lorij
 */
public interface Notificador {
    void notificarLaudo(Laudo laudo);
}
