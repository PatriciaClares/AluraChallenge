package br.com.aluraChallenge.usuario;

import br.com.aluraChallenge.palpite.PalpiteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity cria(@RequestBody @Valid  UsuarioDTO usuarioDTO, @RequestParam(required = false) String bolaoId) {
        return usuarioService.cria(usuarioDTO, bolaoId);
    }

    @PostMapping(value = "/palpite/jogo")
    public ResponseEntity palpita(@RequestBody @Valid PalpiteDTO palpiteDTO) {
        return usuarioService.palpita(palpiteDTO);
    }
}
