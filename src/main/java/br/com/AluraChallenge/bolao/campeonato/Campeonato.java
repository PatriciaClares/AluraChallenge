package br.com.AluraChallenge.bolao.campeonato;

import br.com.AluraChallenge.bolao.time.Time;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Campeonato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private @NotNull @NotBlank String nome;

    private @NotNull @FutureOrPresent LocalDate dataInicio;

    private @NotNull int quantidadeTimesParticipantes;

    public Campeonato() {}

    public Campeonato(String nome, LocalDate dataInicio, int quantidadeTimesParticipantes) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.quantidadeTimesParticipantes = quantidadeTimesParticipantes;
    }
}
