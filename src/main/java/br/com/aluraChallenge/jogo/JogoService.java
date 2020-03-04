package br.com.aluraChallenge.jogo;

import br.com.aluraChallenge.campeonato.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class JogoService {
    private @Autowired JogoRepository jogoRepository;
    private @Autowired CampeonatoRepository campeonatoRepository;
    private @Autowired PlacarRepository placarRepository;

    public ResponseEntity cria(JogoDTO jogoDTO) {
        if (!timesConsistentes(jogoDTO)) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        jogoDTO.setCampeonato(campeonatoRepository.findByNome(jogoDTO.getCampeonatoNome()));
        placarRepository.save(jogoDTO.getPlacar());
        jogoRepository.save(jogoDTO.convert());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private boolean timesConsistentes(JogoDTO jogoDTO) {
        if(jogoDTO.getTimeVisitante().equals(jogoDTO.getTimeCasa()))
            return false;
        Jogo jogo = jogoRepository.findByRodadaAndTimeCasaAndTimeVisitante(jogoDTO.getRodada(), jogoDTO.getTimeCasa(), jogoDTO.getTimeVisitante());
        return jogo == null;
    }
}
