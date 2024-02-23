package edu.apiProyectoJava.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.apiProyectoJava.bean.Acceso;
import edu.apiProyectoJava.servicios.AccesoRepositorio;

/**
 * Clase que controla las opciones de API y la comunicacion a la base de datos para la primera creacion de accesos
 * 
 * @author Isidro Camacho Diaz
 * 
 * @param accesoRepositorio Almacenara los accesos a la base de datos
 */
@RestController
public class DatabaseController {
	@Autowired
	private AccesoRepositorio accesoServicio;
	
	@PostMapping("/InsertarInicio")
	public void insertarAcceso() {
		this.accesoServicio.save(new Acceso("Usuario","Usuario normal de la aplicacion"));
		this.accesoServicio.save(new Acceso("Empleado","Empleado tecnico de la aplicacion"));
		this.accesoServicio.save(new Acceso("Administrador","Administrador tiene control total de la aplicacion"));
	}
}
