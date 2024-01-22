package edu.apiProyectoJava.servicios;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.apiProyectoJava.bean.Incidencia;
import edu.apiProyectoJava.bean.Usuario;

public interface IncidenciaRepositorio extends JpaRepository<Incidencia, Integer>{

}
