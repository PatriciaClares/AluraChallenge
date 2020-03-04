package br.com.aluraChallenge.palpite;

import br.com.aluraChallenge.jogo.Jogo;
import br.com.aluraChallenge.jogo.JogoRepository;
import br.com.aluraChallenge.jogo.Placar;
import br.com.aluraChallenge.jogo.PlacarRepository;
import br.com.aluraChallenge.usuario.Usuario;
import br.com.aluraChallenge.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PalpiteService {
    private @Autowired JogoRepository jogoRepository;
    private @Autowired PlacarRepository placarRepository;
    private @Autowired PalpiteRepository palpiteRepository;
    private @Autowired UsuarioRepository usuarioRepository;

    public ResponseEntity palpita(PalpiteDTO palpiteDTO) {
        Jogo jogo = jogoRepository.findByRodadaAndTimeCasaAndTimeVisitante(palpiteDTO.getJogoDTO().getRodada(), palpiteDTO.getJogoDTO().getTimeCasa(), palpiteDTO.getJogoDTO().getTimeVisitante());
        if (jogo == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        Placar placar = placarRepository.save(palpiteDTO.getPlacar());
        palpiteDTO.setPlacar(placar);
        palpiteDTO.setJogo(jogo);
        palpiteRepository.save(palpiteDTO.convert());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity pontuacao(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        Palpite palpite = usuario.getPalpite();
        Placar placarJogo = usuario.getPalpite().getJogo().getPlacar();
        int pontuacao = geraPontuacao(palpite, placarJogo);
        usuario.getPalpite().setPontuacao(pontuacao);
        palpiteRepository.save(usuario.getPalpite());
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // adicionar mais regras à geração de pontuação
    private int geraPontuacao(Palpite palpite, Placar placarJogo) {
        if (palpite.getJogo().getPlacar().equals(placarJogo)) return 10;
        return 0;
    }
}
