package edu.apiProyectoJava.servicios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.apiProyectoJava.bean.Token;

/**
 * Implementación de la interfaz JpaRepository para la entidad Token.
 * Proporciona métodos para realizar operaciones CRUD en la base de datos.
 * Extiende la interfaz JpaRepository, que es parte del framework Spring Data JPA.
 * 
 * Además de los métodos heredados de JpaRepository, este repositorio
 * proporciona un método adicional para buscar un token por su valor.
 * 
 * @param <Token> Tipo de la entidad gestionada por este repositorio (en este caso, Token).
 * @param <Integer> Tipo del identificador de la entidad (en este caso, Integer).
 * 
 * @author Isidro Camacho Diaz
 */
@Repository
public interface TokenRepositorio extends JpaRepository<Token, Integer>{
	/**
     * Busca un token por su valor.
     * 
     * @param token El valor del token a buscar.
     * @return Un objeto Optional que puede contener el token si se encuentra, o estar vacío si no se encuentra.
     */
	Optional<Token> findByToken(String token);
}