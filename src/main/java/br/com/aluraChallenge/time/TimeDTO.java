package br.com.aluraChallenge.time;

import br.com.aluraChallenge.campeonato.Campeonato;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TimeDTO {
    private @NotNull @NotBlank String nome;
    private @NotNull String dataFundacao;
    private String campeonatoNome;
    private Campeonato campeonato;

    public Time convert() {
        return new Time(this.nome, LocalDate.parse(this.dataFundacao), this.campeonato);
    }

    public String getNome() {
        return nome;
    }

    public String getDataFundacao() {
        return dataFundacao;
    }

    public String getCampeonatoNome() {
        return campeonatoNome;
    }

    public void setCampeonatoNome(String campeonatoNome) {
        this.campeonatoNome = campeonatoNome;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }
}
