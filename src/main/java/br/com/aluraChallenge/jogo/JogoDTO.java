package br.com.aluraChallenge.jogo;

import br.com.aluraChallenge.campeonato.Campeonato;
import br.com.aluraChallenge.utils.DataUtil;
import org.apache.tomcat.jni.Time;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class JogoDTO {
    private @NotNull @NotBlank String timeCasa;
    private @NotNull @NotBlank String timeVisitante;
    private @NotNull @NotBlank String horaComeco;
    private @NotNull @NotBlank String campeonatoNome;
    private Campeonato campeonato;
    private @NotNull int rodada;

    public Jogo convert() {
        return new Jogo(timeCasa, timeVisitante, DataUtil.parse(horaComeco), campeonato, rodada);
    }

    public String getTimeCasa() {
        return timeCasa;
    }

    public String getTimeVisitante() {
        return timeVisitante;
    }

    public String getHoraComeco() {
        return horaComeco;
    }

    public String getCampeonatoNome() {
        return campeonatoNome;
    }

    public int getRodada() {
        return rodada;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }
}
