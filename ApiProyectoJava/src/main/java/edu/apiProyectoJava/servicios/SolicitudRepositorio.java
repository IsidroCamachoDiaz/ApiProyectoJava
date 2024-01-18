package edu.apiProyectoJava.servicios;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.apiProyectoJava.bean.Solicitud;

public interface SolicitudRepositorio extends JpaRepository<Solicitud, Long>{

}
