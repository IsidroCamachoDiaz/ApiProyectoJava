package edu.apiProyectoJava.servicios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.apiProyectoJava.bean.Solicitud;
import edu.apiProyectoJava.bean.Usuario;

public interface SolicitudRepositorio extends JpaRepository<Solicitud, Integer>{
}
