package br.com.aluraChallenge.palpite;

import br.com.aluraChallenge.jogo.Jogo;
import br.com.aluraChallenge.jogo.JogoRepository;
import br.com.aluraChallenge.jogo.Placar;
import br.com.aluraChallenge.jogo.PlacarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PalpiteService {
    private @Autowired JogoRepository jogoRepository;
    private @Autowired PlacarRepository placarRepository;
    private @Autowired PalpiteRepository palpiteRepository;

    public ResponseEntity palpita(PalpiteDTO palpiteDTO) {
        Jogo jogo = jogoRepository.findByRodadaAndTimeCasaAndTimeVisitante(palpiteDTO.getJogoDTO().getRodada(), palpiteDTO.getJogoDTO().getTimeCasa(), palpiteDTO.getJogoDTO().getTimeVisitante());
        if (jogo == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        Placar placar = placarRepository.save(palpiteDTO.getPlacar());
        palpiteDTO.setPlacar(placar);
        palpiteDTO.setJogo(jogo);
        palpiteRepository.save(palpiteDTO.convert());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
