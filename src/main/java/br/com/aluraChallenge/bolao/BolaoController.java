package br.com.aluraChallenge.bolao;

import br.com.aluraChallenge.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/bolao")
public class BolaoController {
    @Autowired
    private BolaoService bolaoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity cria(@RequestBody @Valid BolaoDTO bolaoDTO) {
        return bolaoService.cria(bolaoDTO);
    }

    @PutMapping
    @RequestMapping(value = "/participantes")
    public ResponseEntity aceitaConviteBolao(@RequestParam String email, @RequestParam String bolaoId) {
        return bolaoService.aceitaConviteBolao(email, bolaoId);
    }
}
