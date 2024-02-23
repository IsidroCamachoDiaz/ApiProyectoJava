package edu.apiProyectoJava.servicios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.apiProyectoJava.bean.Acceso;
/**
 * Implementación de la interfaz JpaRepository para la entidad Acceso.
 * Proporciona métodos para realizar operaciones CRUD en la base de datos.
 * Extiende la interfaz JpaRepository, que es parte del framework Spring Data JPA.
 * 
 * Además de los métodos heredados de JpaRepository, este repositorio también proporciona
 * un método personalizado para buscar un Acceso por su código de acceso.
 * 
 * @param <Acceso> Tipo de la entidad gestionada por este repositorio (en este caso, Acceso).
 * @param <Integer> Tipo del identificador de la entidad (en este caso, Integer).
 * 
 * @author Isidro Camacho Diaz
 */
@Repository
public interface AccesoRepositorio extends JpaRepository<Acceso, Integer>{
	Acceso findByCodigoAcceso(String codigo);
}
