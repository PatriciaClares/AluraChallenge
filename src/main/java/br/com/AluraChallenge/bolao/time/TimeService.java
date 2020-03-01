package br.com.AluraChallenge.bolao.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TimeService {
    @Autowired
    private TimeRepository timeRepository;

    @Transactional
    public ResponseEntity cria(TimeDTO timeDTO) {
        timeRepository.save(timeDTO.convert());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
