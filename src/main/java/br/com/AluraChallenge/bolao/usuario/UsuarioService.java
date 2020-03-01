package br.com.AluraChallenge.bolao.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public ResponseEntity cria(UsuarioDTO usuarioDTO) {
         usuarioRepository.save(usuarioDTO.convert());
         return ResponseEntity.status(HttpStatus.OK).build();
    }
}
