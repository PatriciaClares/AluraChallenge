package br.com.AluraChallenge.usuario;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private @NotNull @NotBlank @Email String email;

    private @Size(min = 6) String senha;

    private @NotNull @PastOrPresent LocalDateTime dataCriacao = LocalDateTime.now();

    public Usuario() {}

    public Usuario(@NotNull @NotBlank String email, @NotNull @NotBlank String senha) {
        this.email = email;
        this.senha = senha;
    }
}
