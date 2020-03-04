package br.com.aluraChallenge.bolao;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NotNull @Email String email;

    private char participando = 0;

    private @URL String conviteLink;

    private LocalDateTime momentoConviteAceito;

    public Participante() {}

    public Participante(String email, String conviteLink) {
        this.email = email;
        this.conviteLink = conviteLink;
    }

    public Participante(String email, char participando, LocalDateTime momentoConviteAceito) {
        this.email = email;
        this.participando = participando;
        this.momentoConviteAceito = momentoConviteAceito;
    }

    public Participante(String email, char participando, LocalDateTime momentoConviteAceito, String conviteLink) {
        this(email, participando, momentoConviteAceito);
        this.conviteLink = conviteLink;
    }
}
