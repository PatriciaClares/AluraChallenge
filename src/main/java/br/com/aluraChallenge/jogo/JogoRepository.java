package br.com.aluraChallenge.jogo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
    Jogo findByRodadaAndTimeCasa(int rodada, String timeCasa);

    Jogo findByRodadaAndTimeVisitante(int rodada, String timeVisitante);

    Jogo findByRodadaAndTimeCasaAndTimeVisitante(int rodada, String timeCasa, String timeVisitante);
}
