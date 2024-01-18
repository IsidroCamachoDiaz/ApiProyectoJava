package edu.apiProyectoJava.servicios;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.apiProyectoJava.bean.TipoIncidencia;
import edu.apiProyectoJava.bean.Usuario;

public interface TipoIncidenciaRepositorio extends JpaRepository<TipoIncidencia, Long>{

}
