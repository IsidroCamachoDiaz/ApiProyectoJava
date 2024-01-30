package edu.apiProyectoJava.controladores;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.apiProyectoJava.servicios.AccesoRepositorio;

import edu.apiProyectoJava.bean.Acceso;

/**
 * Clase que controla las opciones de API y la comunicacion a la base de datos para los Accesos
 * 
 * @author Isidro Camacho Diaz
 * 
 * @param AccesoServicio Almacenara el acceso Al Servidor
 */
@RestController
@RequestMapping("/acceso")
public class AccesoController {

	@Autowired
	private AccesoRepositorio accesoServicio;
	/**
	 * Devuelve todos los Accesos con la peticion GET
	 * @return Iterable<Acceso> Objeto que almacena todos los acessos 
	 */
	@GetMapping("/Select")
	public Iterable<Acceso> obtenerAcceso() {	
	return this.accesoServicio.findAll();
	}
	
	/**
	  * Devuelve un Acceso en concreto dependiendo del id insertado con la peticion GET
	 * @param id Identificacion que usaremos para diferenciar a otros Accesos
	 * @return Optional<Acceso> Devuelve una Coleccion de Acceso o nulo 
	 */
	@GetMapping(path="/Select/{id}")
	public Optional<Acceso> obtenerAccesoID(@PathVariable("id") int id) {	
	return this.accesoServicio.findById(id);
	}
	
	
	/**
	 * Inserta un Acceso por el metodo POST
	 * @param Acceso Objetos Acceso
	 */
	@PostMapping("/Insertar")
	public void insertarAcceso(@RequestBody Acceso acceso) {
		this.accesoServicio.save(acceso);
	}
	
	/**
	 * Actualiza un Acceso en concreto por el id mediante el metodo PUST
	 * @param id Variable por el cual identificaremos el Acceso
	 * @param Acceso acceso
	 */
	@PutMapping(path="/Actualizar/{id}")
	public void actualizarAcceso(@RequestBody Acceso acceso,@PathVariable("id") int id) {
		Acceso accesoObetnido=accesoServicio.findById(id).get();
		accesoObetnido.setCodigoAcceso(acceso.getCodigoAcceso());
		accesoObetnido.setDescripcionAcceso(acceso.getDescripcionAcceso());
		accesoServicio.save(accesoObetnido);
	}
	
	/**
	  * Eliminar un Acceso en concreto mediante el metodo DELETE
	 * @param id Variable por el cual identificaremos el Acceso
	 * @return Boolean Devolvera "true" si se a Eliminado correctamente o "false" si a habido algun problema
	 */
	@DeleteMapping(path="/Eliminar/{id}")
	public Boolean eliminarAcceso(@PathVariable("id") int id) {
		try {
			accesoServicio.deleteById(id);
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		return true;
	}
}
