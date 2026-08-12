package com.davidmatias.usuarios_api.repository;

import com.davidmatias.usuarios_api.model.RefreshToken;
import com.davidmatias.usuarios_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByToken(String token);

    void deleteByUsuario(Usuario usuario);
}