package br.com.AluraChallenge.time;

import br.com.AluraChallenge.campeonato.Campeonato;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private @NotNull @NotBlank String nome;

    private @NotNull @Past LocalDate dataFundacao;

    @ManyToOne
    private Campeonato campeonato;

    public Time() {}

    public Time(String nome, LocalDate dataFundacao) {
        this.nome = nome;
        this.dataFundacao = dataFundacao;
    }

    public Time(String nome, LocalDate dataFundacao, Campeonato campeonato) {
        this(nome, dataFundacao);
        this.campeonato = campeonato;
    }
}
