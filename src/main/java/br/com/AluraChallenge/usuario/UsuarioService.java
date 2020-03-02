package br.com.AluraChallenge.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public ResponseEntity cria(UsuarioDTO usuarioDTO) {
        usuarioDTO.setSenha(new BCryptPasswordEncoder().encode(usuarioDTO.getSenha()));
        usuarioRepository.save(usuarioDTO.convert());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
