package br.com.aluraChallenge.palpite;

import br.com.aluraChallenge.jogo.JogoDTO;
import br.com.aluraChallenge.jogo.Placar;

import javax.validation.constraints.NotNull;

public class PalpiteDTO {
    private @NotNull JogoDTO jogoDTO;
    private @NotNull Placar placar;

    public Palpite convert() {
        return new Palpite(this.jogoDTO.convert(), this.placar);
    }

    public JogoDTO getJogoDTO() {
        return jogoDTO;
    }

    public Placar getPlacar() {
        return placar;
    }

    public void setPlacar(Placar placar) {
        this.placar = placar;
    }
}
