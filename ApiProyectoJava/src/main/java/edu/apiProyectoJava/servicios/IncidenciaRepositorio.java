package edu.apiProyectoJava.servicios;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.apiProyectoJava.bean.Incidencia;
import edu.apiProyectoJava.bean.Usuario;

/**
 * Implementación de la interfaz JpaRepository para la entidad Incidencia.
 * Proporciona métodos para realizar operaciones CRUD en la base de datos.
 * Extiende la interfaz JpaRepository, que es parte del framework Spring Data JPA.
 * 
 * @param <Incidencia> Tipo de la entidad gestionada por este repositorio (en este caso, Incidencia).
 * @param <Integer> Tipo del identificador de la entidad (en este caso, Integer).
 * 
 * @author Isidro Camacho Diaz
 */
public interface IncidenciaRepositorio extends JpaRepository<Incidencia, Integer>{

}
