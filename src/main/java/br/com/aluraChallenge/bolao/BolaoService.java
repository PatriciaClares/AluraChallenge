package br.com.aluraChallenge.bolao;

import br.com.aluraChallenge.campeonato.CampeonatoRepository;
import br.com.aluraChallenge.usuario.Usuario;
import br.com.aluraChallenge.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BolaoService {
    @Autowired
    private BolaoRepository bolaoRepository;

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Transactional
    public ResponseEntity cria(BolaoDTO bolaoDTO) {
        List<Participante> participantes = new ArrayList<>();
        for (String email : bolaoDTO.getEmailParticipantes())
            participantes.add(new Participante(email, bolaoDTO.getConviteLink()));
        bolaoDTO.setParticipantes(participantes);
        bolaoDTO.setUsuario(usuarioRepository.findByEmail(bolaoDTO.getUsuarioEmail()));
        bolaoDTO.setCampeonato(campeonatoRepository.findByNome(bolaoDTO.getCampeonatoNome()));
        bolaoRepository.save(bolaoDTO.convert());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity aceitaConviteBolao(String email, String bolaoId) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        Bolao bolao = bolaoRepository.findById(Long.parseLong(bolaoId)).orElse(null);
        if(bolao == null || bolao.getDataExpiracaoConvite().isBefore(LocalDateTime.now()))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        Participante participante = participanteRepository.save(new Participante(email, (char) 1, LocalDateTime.now(), bolao.getConviteLink()));
        bolao.getParticipantes().add(participante);
        bolaoRepository.save(bolao);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
