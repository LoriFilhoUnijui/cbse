package br.edu.unijui.reuso.saude.componentes.laudo;

import br.edu.unijui.reuso.saude.api.EmissaoLaudo;
import br.edu.unijui.reuso.saude.api.dto.Consulta;
import br.edu.unijui.reuso.saude.api.dto.Laudo;

import java.time.LocalDateTime;

/**
 *
 * @author lorij
 */
public class EmissaoLaudoSimples implements EmissaoLaudo {
    @Override
    public Laudo emitir(Consulta consulta, String conteudo) {
        return new Laudo(consulta.getId(), conteudo, LocalDateTime.now());
    }
}
