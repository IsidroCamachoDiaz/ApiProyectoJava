package edu.apiProyectoJava.servicios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.apiProyectoJava.bean.Solicitud;
import edu.apiProyectoJava.bean.Usuario;

/**
 * Implementación de la interfaz JpaRepository para la entidad Solicitud.
 * Proporciona métodos para realizar operaciones CRUD en la base de datos.
 * Extiende la interfaz JpaRepository, que es parte del framework Spring Data JPA.
 * 
 * @param <Solicitud> Tipo de la entidad gestionada por este repositorio (en este caso, Solicitud).
 * @param <Integer> Tipo del identificador de la entidad (en este caso, Integer).
 * 
 * @author Isidro Camacho Diaz
 */
public interface SolicitudRepositorio extends JpaRepository<Solicitud, Integer>{
}
