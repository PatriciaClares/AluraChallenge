package br.com.AluraChallenge.usuario;

import br.com.AluraChallenge.bolao.Bolao;
import br.com.AluraChallenge.bolao.BolaoRepository;
import br.com.AluraChallenge.bolao.Participante;
import br.com.AluraChallenge.bolao.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BolaoRepository bolaoRepository;

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Transactional
    public ResponseEntity cria(UsuarioDTO usuarioDTO, String bolaoId) {
        usuarioDTO.setSenha(new BCryptPasswordEncoder().encode(usuarioDTO.getSenha()));
        usuarioRepository.save(usuarioDTO.convert());
        if (bolaoId != null)
            return cadastraUsuarioNoBolao(usuarioDTO, bolaoId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private ResponseEntity cadastraUsuarioNoBolao(UsuarioDTO usuarioDTO, String bolaoId) {
        Bolao bolao = bolaoRepository.findById(Long.parseLong(bolaoId)).orElse(null);
        if (bolao == null || bolao.getDataExpiracaoConvite().isBefore(LocalDateTime.now()))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bolão não existe ou convite expirado");
        Participante participante = participanteRepository.save(new Participante(usuarioDTO.getEmail(), (char) 1, LocalDateTime.now(), bolao.getConviteLink()));
        bolao.getParticipantes().add(participante);
        bolaoRepository.save(bolao);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
