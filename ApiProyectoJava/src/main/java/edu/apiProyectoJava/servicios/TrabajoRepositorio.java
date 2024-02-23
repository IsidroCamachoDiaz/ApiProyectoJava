package edu.apiProyectoJava.servicios;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.apiProyectoJava.bean.Token;
import edu.apiProyectoJava.bean.Trabajo;

/**
 * Implementación de la interfaz JpaRepository para la entidad Trabajo.
 * Proporciona métodos para realizar operaciones CRUD en la base de datos.
 * Extiende la interfaz JpaRepository, que es parte del framework Spring Data JPA.
 * 
 * @param <Trabajo> Tipo de la entidad gestionada por este repositorio (en este caso, Trabajo).
 * @param <Integer> Tipo del identificador de la entidad (en este caso, Integer).
 * 
 * @author Isidro Camacho Diaz
 */
public interface TrabajoRepositorio extends JpaRepository<Trabajo, Integer>{

}
