package br.com.aluraChallenge.usuario;

import br.com.aluraChallenge.bolao.Bolao;
import br.com.aluraChallenge.bolao.BolaoRepository;
import br.com.aluraChallenge.bolao.Participante;
import br.com.aluraChallenge.bolao.ParticipanteRepository;
import br.com.aluraChallenge.jogo.Jogo;
import br.com.aluraChallenge.jogo.JogoRepository;
import br.com.aluraChallenge.jogo.Placar;
import br.com.aluraChallenge.jogo.PlacarRepository;
import br.com.aluraChallenge.palpite.PalpiteDTO;
import br.com.aluraChallenge.palpite.PalpiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class UsuarioService {
    private @Autowired UsuarioRepository usuarioRepository;
    private @Autowired BolaoRepository bolaoRepository;
    private @Autowired ParticipanteRepository participanteRepository;
    private @Autowired PalpiteRepository palpiteRepository;
    private @Autowired JogoRepository jogoRepository;
    private @Autowired PlacarRepository placarRepository;

    @Transactional
    public ResponseEntity cria(UsuarioDTO usuarioDTO, String bolaoId) {
        usuarioDTO.setSenha(new BCryptPasswordEncoder().encode(usuarioDTO.getSenha()));
        usuarioRepository.save(usuarioDTO.convert());
        if (bolaoId != null)
            return cadastraUsuarioNoBolao(usuarioDTO, bolaoId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private ResponseEntity cadastraUsuarioNoBolao(UsuarioDTO usuarioDTO, String bolaoId) {
        Bolao bolao = bolaoRepository.findById(Long.parseLong(bolaoId)).orElse(null);
        if (bolao == null || bolao.getDataExpiracaoConvite().isBefore(LocalDateTime.now()))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bolão não existe ou convite expirado");
        Participante participante = participanteRepository.save(new Participante(usuarioDTO.getEmail(), (char) 1, LocalDateTime.now(), bolao.getConviteLink()));
        bolao.getParticipantes().add(participante);
        bolaoRepository.save(bolao);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity palpita(PalpiteDTO palpiteDTO) {
        Jogo jogo = jogoRepository.findByRodadaAndTimeCasaAndTimeVisitante(palpiteDTO.getJogoDTO().getRodada(), palpiteDTO.getJogoDTO().getTimeCasa(), palpiteDTO.getJogoDTO().getTimeVisitante());
        if (jogo == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        Placar placar = placarRepository.save(palpiteDTO.getPlacar());
        palpiteDTO.setPlacar(placar);
        // talvez o jogo não possa ser salvo dnv aqui!!
        palpiteRepository.save(palpiteDTO.convert());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
