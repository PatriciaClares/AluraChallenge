package br.com.AluraChallenge.bolao.usuario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UsuarioDTO {
    private @NotNull @NotBlank String email;
    private @NotNull @NotBlank String senha;

    public Usuario convert() {
        return new Usuario(this.email, this.senha);
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
