package edu.apiProyectoJava.servicios;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.apiProyectoJava.bean.Token;
import edu.apiProyectoJava.bean.Trabajo;

/**
 * Implementacion de la Interface Trabajo que extiende Jpa 
 * @author Isidro Camacho Diaz
 */
public interface TrabajoRepositorio extends JpaRepository<Trabajo, Long>{

}
