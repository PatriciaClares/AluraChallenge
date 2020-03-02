package br.com.AluraChallenge.time;

import br.com.AluraChallenge.campeonato.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TimeService {
    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    @Transactional
    public ResponseEntity cria(TimeDTO timeDTO) {
        timeDTO.setCampeonato(campeonatoRepository.findByNome(timeDTO.getCampeonatoNome()));
        timeRepository.save(timeDTO.convert());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
