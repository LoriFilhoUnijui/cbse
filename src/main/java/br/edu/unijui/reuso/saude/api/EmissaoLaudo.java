package br.edu.unijui.reuso.saude.api;

import br.edu.unijui.reuso.saude.api.dto.Consulta;
import br.edu.unijui.reuso.saude.api.dto.Laudo;

/**
 *
 * @author lorij
 */
public interface EmissaoLaudo {
    Laudo emitir(Consulta consulta, String conteudo);
}
