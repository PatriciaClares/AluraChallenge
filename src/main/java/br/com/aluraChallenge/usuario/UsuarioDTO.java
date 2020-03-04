package br.com.aluraChallenge.usuario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UsuarioDTO {
    private @NotNull @NotBlank String email;
    private @NotNull @NotBlank String senha;

    public Usuario convert() {
        return new Usuario(email, senha);
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
