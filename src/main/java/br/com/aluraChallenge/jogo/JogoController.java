package br.com.aluraChallenge.jogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/jogo")
public class JogoController {
    @Autowired
    private JogoService jogoService;

    @PostMapping
    public ResponseEntity cria(@RequestBody @Valid JogoDTO jogoDTO) {
        return jogoService.cria(jogoDTO);
    }
}
