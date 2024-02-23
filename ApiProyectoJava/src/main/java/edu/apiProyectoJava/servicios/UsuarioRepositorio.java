package edu.apiProyectoJava.servicios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.apiProyectoJava.bean.Acceso;
import edu.apiProyectoJava.bean.Token;
import edu.apiProyectoJava.bean.Usuario;
/**
 * Implementación de la interfaz JpaRepository para la entidad Usuario.
 * Proporciona métodos para realizar operaciones CRUD en la base de datos.
 * Extiende la interfaz JpaRepository, que es parte del framework Spring Data JPA.
 * 
 * @param <Usuario> Tipo de la entidad gestionada por este repositorio (en este caso, Usuario).
 * @param <Integer> Tipo del identificador de la entidad (en este caso, Integer).
 * 
 * @author Isidro Camacho Diaz
 */
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
	/**
     * Encuentra un usuario por su dirección de correo electrónico.
     *
     * @param correo La dirección de correo electrónico del usuario a buscar.
     * @return Un Optional que contiene el usuario encontrado, si existe.
     */
	Optional<Usuario> findByCorreo(String correo);
}
