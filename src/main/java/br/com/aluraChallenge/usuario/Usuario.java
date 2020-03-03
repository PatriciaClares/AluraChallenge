package br.com.aluraChallenge.usuario;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Usuario {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private @Column(unique=true) @NotNull @NotBlank @Email String email;
    private @Size(min = 6) String senha;
    private @NotNull @PastOrPresent LocalDateTime dataCriacao = LocalDateTime.now();

    public Usuario() {}

    public Usuario(@NotNull @NotBlank String email, @NotNull @NotBlank String senha) {
        this.email = email;
        this.senha = senha;
    }
}
