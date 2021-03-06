package br.com.aluraChallenge.usuario;

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
}
