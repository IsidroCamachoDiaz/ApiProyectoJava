package edu.apiProyectoJava.servicios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.apiProyectoJava.bean.Acceso;
/**
 * Implementacion de la Interface Acceso que extiende Jpa 
 * @author El Equipazo de los Lentos
 */
@Repository
public interface AccesoRepositorio extends JpaRepository<Acceso, Integer>{
 Acceso findByCodigoAcceso(String codigo);
}
