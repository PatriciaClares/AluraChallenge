package br.com.aluraChallenge.jogo;

import br.com.aluraChallenge.campeonato.Campeonato;
import br.com.aluraChallenge.utils.DataUtil;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class JogoDTO {
    // email do usuario só para fins de autenticacao
    private @Email String emailUsuario;
    private @NotNull @NotBlank String timeCasa;
    private @NotNull @NotBlank String timeVisitante;
    private @NotNull @NotBlank String horaComeco;
    private @NotNull @NotBlank String campeonatoNome;
    private Campeonato campeonato;
    private @NotNull int rodada;
    private Placar placar;

    public Jogo convert() {
        if (this.placar == null)
            return new Jogo(timeCasa, timeVisitante, DataUtil.parse(horaComeco), campeonato, rodada);
        return new Jogo(timeCasa, timeVisitante, DataUtil.parse(horaComeco), campeonato, rodada, placar);
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

    public Placar getPlacar() {
        return placar;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }
}
