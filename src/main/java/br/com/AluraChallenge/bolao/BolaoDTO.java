package br.com.AluraChallenge.bolao;

import br.com.AluraChallenge.campeonato.Campeonato;
import br.com.AluraChallenge.usuario.Usuario;
import br.com.AluraChallenge.utils.DataUtil;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

public class BolaoDTO {
    private @NotNull @Email String usuarioEmail;
    private Usuario usuario;
    private @PastOrPresent LocalDateTime dataCriacao = LocalDateTime.now();
    private @NotNull @NotBlank String campeonatoNome;
    private Campeonato campeonato;
    private @NotNull List<String> emailParticipantes;
    private List<Participante> participantes;
    private @NotNull @URL String conviteLink;
    private @NotNull @NotBlank String dataExpiracaoConvite;

    public Bolao convert() {
        return new Bolao(usuario, dataCriacao, campeonato, participantes, conviteLink, DataUtil.parse( dataExpiracaoConvite));
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getCampeonatoNome() {
        return campeonatoNome;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public String getConviteLink() {
        return conviteLink;
    }

    public String getDataExpiracaoConvite() {
        return dataExpiracaoConvite;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public List<String> getEmailParticipantes() {
        return emailParticipantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }
}
