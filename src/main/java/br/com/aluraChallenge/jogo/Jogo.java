package br.com.aluraChallenge.jogo;

import br.com.aluraChallenge.campeonato.Campeonato;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotNull @Future LocalDateTime horaComeco;
    private @NotNull String timeCasa;
    private @NotNull String timeVisitante;
    private @NotNull int rodada;
    private @ManyToOne @NotNull Campeonato campeonato;
    private @OneToOne Placar placar;

    public Jogo() {}

    public Jogo(String timeCasa, String timeVisitante, LocalDateTime horaComeco, Campeonato campeonato, int rodada) {
        this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
        this.horaComeco = horaComeco;
        this.campeonato = campeonato;
        this.rodada = rodada;
    }

    public Jogo(String timeCasa, String timeVisitante, LocalDateTime horaComeco, Campeonato campeonato, int rodada, Placar placar) {
        this(timeCasa, timeVisitante, horaComeco, campeonato, rodada);
        this.placar = placar;
    }
}
