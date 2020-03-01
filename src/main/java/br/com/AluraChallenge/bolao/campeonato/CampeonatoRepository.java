package br.com.AluraChallenge.bolao.campeonato;

import br.com.AluraChallenge.bolao.campeonato.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato, Long> {
    Campeonato findByNome(String campeonatoNome);
}
