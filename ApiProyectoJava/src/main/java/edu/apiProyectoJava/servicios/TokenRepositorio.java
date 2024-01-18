package edu.apiProyectoJava.servicios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.apiProyectoJava.bean.Token;

/**
 * Implementacion de la Interface Acceso que extiende Jpa 
 * @author El grupazo de los Lentos
 */
@Repository
public interface TokenRepositorio extends JpaRepository<Token, Long>{
	Optional<Token> findByToken(String token);
}