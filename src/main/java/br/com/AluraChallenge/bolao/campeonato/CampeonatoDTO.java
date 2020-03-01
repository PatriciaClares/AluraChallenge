package br.com.AluraChallenge.bolao.campeonato;

import br.com.AluraChallenge.bolao.time.Time;
import br.com.AluraChallenge.bolao.time.TimeDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class CampeonatoDTO {
    private @NotNull @NotBlank String nome;
    private @NotNull String dataInicio;
    private @NotNull int quantidadeTimesParticipantes;

    public Campeonato convert() {
        return new Campeonato(this.nome, LocalDate.parse(dataInicio), this.quantidadeTimesParticipantes);
    }

    public String getNome() {
        return nome;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public int getQuantidadeTimesParticipantes() {
        return quantidadeTimesParticipantes;
    }
}
