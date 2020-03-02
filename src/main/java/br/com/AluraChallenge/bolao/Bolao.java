package br.com.AluraChallenge.bolao;

import br.com.AluraChallenge.campeonato.Campeonato;
import br.com.AluraChallenge.usuario.Usuario;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Bolao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private @NotNull Usuario usuario;

    private @NotNull @PastOrPresent LocalDateTime dataCriacao;

    @OneToOne
    private @NotNull Campeonato campeonato;

    @OneToMany
    private @NotNull List<Participante> participantes;

    private @NotNull @URL String conviteLink;

    private @NotNull @FutureOrPresent LocalDateTime dataExpiracaoConvite;

    public Bolao() {}

    public Bolao(Usuario usuario, LocalDateTime dataCriacao, Campeonato campeonato, List<Participante> participantes,
                 String conviteLink, LocalDateTime dataExpiracaoConvite) {
        this.usuario = usuario;
        this.dataCriacao = dataCriacao;
        this.campeonato = campeonato;
        this.participantes = participantes;
        this.conviteLink = conviteLink;
        this.dataExpiracaoConvite = dataExpiracaoConvite;
    }
}
