package br.com.aluraChallenge.campeonato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CampeonatoService {
    @Autowired
    private CampeonatoRepository campeonatoRepository;

    @Transactional
    public ResponseEntity cria(CampeonatoDTO campeonatoDTO) {
        campeonatoRepository.save(campeonatoDTO.convert());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
