package br.com.aluraChallenge.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/time")
public class TimeController {
    @Autowired
    private TimeService timeService;

    @PostMapping
    public ResponseEntity cria(@RequestBody @Valid TimeDTO timeDTO) {
        return timeService.cria(timeDTO);
    }
}
