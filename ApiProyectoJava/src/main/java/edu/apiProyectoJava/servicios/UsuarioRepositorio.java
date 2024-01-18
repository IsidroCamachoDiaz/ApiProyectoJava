package edu.apiProyectoJava.servicios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.apiProyectoJava.bean.Acceso;
import edu.apiProyectoJava.bean.Token;
import edu.apiProyectoJava.bean.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByCorreo(String correo);
}
