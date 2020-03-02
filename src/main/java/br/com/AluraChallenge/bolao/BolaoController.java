package br.com.AluraChallenge.bolao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/bolao")
public class BolaoController {
    @Autowired
    private BolaoService bolaoService;

    @PostMapping
    public ResponseEntity cria(@RequestBody @Valid BolaoDTO bolaoDTO) {
        return bolaoService.cria(bolaoDTO);
    }
}
