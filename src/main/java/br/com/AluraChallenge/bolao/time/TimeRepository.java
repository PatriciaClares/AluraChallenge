package br.com.AluraChallenge.bolao.time;

import br.com.AluraChallenge.bolao.campeonato.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {}
