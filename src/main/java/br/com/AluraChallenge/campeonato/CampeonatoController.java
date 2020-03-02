package br.com.AluraChallenge.campeonato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/campeonato")
public class CampeonatoController {
    @Autowired
    private CampeonatoService campeonatoService;

    @PostMapping
    public ResponseEntity cria(@RequestBody @Valid CampeonatoDTO campeonatoDTO) {
        return campeonatoService.cria(campeonatoDTO);
    }
}
