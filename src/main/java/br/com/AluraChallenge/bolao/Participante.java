package br.com.AluraChallenge.bolao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.servlet.http.Part;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NotNull @NotBlank @Email String email;
    private char participando = 0;

    public Participante() {}

    public Participante(String email) {
        this.email = email;
    }
}
