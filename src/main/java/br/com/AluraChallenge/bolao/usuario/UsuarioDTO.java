package br.com.AluraChallenge.bolao.usuario;

public class UsuarioDTO {
    private String email;
    private String senha;

    public Usuario convert() {
        return new Usuario(email, senha);
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
