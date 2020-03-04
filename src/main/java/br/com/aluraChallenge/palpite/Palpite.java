package br.com.aluraChallenge.palpite;

import br.com.aluraChallenge.jogo.Jogo;
import br.com.aluraChallenge.jogo.Placar;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Palpite {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private @ManyToOne @NotNull Jogo jogo;
    private @OneToOne @NotNull Placar placar;
    private int pontuacao;

    public Palpite() {}

    public Palpite(Jogo jogo, Placar placar) {
        this.jogo = jogo;
        this.placar = placar;
    }

    public Palpite(Jogo jogo, Placar placar, int pontuacao) {
        this(jogo, placar);
        this.pontuacao = pontuacao;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
