package br.com.aluraChallenge.jogo;

import br.com.aluraChallenge.campeonato.CampeonatoRepository;
import br.com.aluraChallenge.time.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class JogoService {
    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    public ResponseEntity cria(JogoDTO jogoDTO) {
        if (!timesConsistentes(jogoDTO)) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        jogoDTO.setCampeonato(campeonatoRepository.findByNome(jogoDTO.getCampeonatoNome()));
        jogoRepository.save(jogoDTO.convert());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private boolean timesConsistentes(JogoDTO jogoDTO) {
        if(jogoDTO.getTimeVisitante().equals(jogoDTO.getTimeCasa()))
            return false;
        Jogo jogoTimeCasa = jogoRepository.findByRodadaAndTimeCasa(jogoDTO.getRodada(), jogoDTO.getTimeCasa());
        Jogo jogoTimeVisitante = jogoRepository.findByRodadaAndTimeVisitante(jogoDTO.getRodada(), jogoDTO.getTimeVisitante());
        return jogoTimeCasa == null || jogoTimeVisitante == null;
    }
}
