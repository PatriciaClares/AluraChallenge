package br.com.aluraChallenge.palpite;

import br.com.aluraChallenge.jogo.Jogo;
import br.com.aluraChallenge.jogo.JogoDTO;
import br.com.aluraChallenge.jogo.Placar;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class PalpiteDTO {
    private @Email @NotNull String emailUsuario;
    private @NotNull JogoDTO jogoDTO;
    private Jogo jogo;
    private @NotNull Placar placar;

    public Palpite convert() {
        return new Palpite(this.jogo, this.placar, this.placar.getTimeVencedor());
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

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }
}
