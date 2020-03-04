package br.com.aluraChallenge.usuario;

import br.com.aluraChallenge.palpite.Palpite;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Usuario {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private @Column(unique=true) @NotNull @NotBlank @Email String email;
    private @Size(min = 6) String senha;
    private @NotNull @PastOrPresent LocalDateTime dataCriacao = LocalDateTime.now();
    private @OneToOne Palpite palpite;

    public Usuario() {}

    public Usuario(@NotNull @NotBlank String email, @NotNull @NotBlank String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Palpite getPalpite() {
        return palpite;
    }

    public void setPalpite(Palpite palpite) {
        this.palpite = palpite;
    }
}
