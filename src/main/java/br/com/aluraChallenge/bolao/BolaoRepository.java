package br.com.aluraChallenge.bolao;

import br.com.aluraChallenge.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolaoRepository extends JpaRepository<Bolao, Long> {
    Bolao findByUsuario(Usuario usuario);
}
