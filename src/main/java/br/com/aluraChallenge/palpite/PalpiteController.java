package br.com.aluraChallenge.palpite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/palpite")
public class PalpiteController {
    private @Autowired PalpiteService palpiteService;

    @PostMapping(value = "/jogo")
    public ResponseEntity palpita(@RequestBody @Valid PalpiteDTO palpiteDTO) {
        return palpiteService.palpita(palpiteDTO);
    }
}
