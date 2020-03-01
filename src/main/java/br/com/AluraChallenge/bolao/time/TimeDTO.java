package br.com.AluraChallenge.bolao.time;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class TimeDTO {
    private @NotNull @NotBlank String nome;
    private @NotNull @NotBlank String dataFundacao;

    public Time convert() {
        return new Time(this.nome, LocalDate.parse(this.dataFundacao));
    }

    public String getNome() {
        return nome;
    }

    public String getDataFundacao() {
        return dataFundacao;
    }
}
