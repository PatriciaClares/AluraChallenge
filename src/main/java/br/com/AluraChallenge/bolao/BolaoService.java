package br.com.AluraChallenge.bolao;

import br.com.AluraChallenge.campeonato.CampeonatoRepository;
import br.com.AluraChallenge.usuario.Usuario;
import br.com.AluraChallenge.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public ResponseEntity cria(BolaoDTO bolaoDTO) {
        List<Participante> participantes = new ArrayList<>();
        for (String email : bolaoDTO.getEmailParticipantes())
            participantes.add(new Participante(email));
        bolaoDTO.setParticipantes(participantes);
        bolaoDTO.setUsuario(usuarioRepository.findByEmail(bolaoDTO.getUsuarioEmail()));
        bolaoDTO.setCampeonato(campeonatoRepository.findByNome(bolaoDTO.getCampeonatoNome()));
        bolaoRepository.save(bolaoDTO.convert());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
