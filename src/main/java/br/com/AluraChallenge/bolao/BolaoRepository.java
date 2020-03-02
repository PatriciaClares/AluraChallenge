package br.com.AluraChallenge.bolao;

import br.com.AluraChallenge.campeonato.Campeonato;
import br.com.AluraChallenge.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolaoRepository extends JpaRepository<Bolao, Long> {
    Bolao findByUsuario(Usuario usuario);
}
