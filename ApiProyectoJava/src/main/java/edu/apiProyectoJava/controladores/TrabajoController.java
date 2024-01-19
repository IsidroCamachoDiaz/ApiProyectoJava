package edu.apiProyectoJava.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.apiProyectoJava.bean.Acceso;
import edu.apiProyectoJava.bean.Trabajo;
import edu.apiProyectoJava.servicios.AccesoRepositorio;
import edu.apiProyectoJava.servicios.TrabajoRepositorio;

/**
 * Clase que controla las opciones de API y la comunicacion a la base de datos para los Accesos
 * 
 * @author Isidro Camacho Diaz
 * 
 * @param AccesoServicio Almacenara el acceso Al Servidor
 */
@RestController
@RequestMapping("/trabajo")
public class TrabajoController {
	@Autowired
	private TrabajoRepositorio trabajoRepositorio;
	
	/**
	 * Devuelve todos los Trabajos con la petición GET.
	 *
	 * @return Iterable<Trabajo> Objeto que almacena todos los trabajos.
	 */
	@GetMapping("/Select")
	public Iterable<Trabajo> obtenerTrabajo() {
	    return this.trabajoRepositorio.findAll();
	}

	/**
	 * Devuelve un Trabajo en concreto dependiendo del ID insertado con la petición GET.
	 *
	 * @param id Identificación que usaremos para diferenciar a otros Trabajos.
	 * @return Optional<Trabajo> Devuelve una colección de Trabajo o nulo.
	 */
	@GetMapping(path="/Select/{id}")
	public Optional<Trabajo> obtenerTrabajoID(@PathVariable("id") Long id) {
	    return this.trabajoRepositorio.findById(id);
	}

	/**
	 * Inserta un Trabajo por el método POST.
	 *
	 * @param trabajo Objeto Trabajo a insertar.
	 */
	@PostMapping("/Insertar")
	public void insertarTrabajo(@RequestBody Trabajo trabajo) {
	    this.trabajoRepositorio.save(trabajo);
	}

	/**
	 * Actualiza un Trabajo en concreto por el ID mediante el método PUT.
	 *
	 * @param id      Variable por la cual identificaremos el Trabajo.
	 * @param trabajo Objeto Trabajo con los datos actualizados.
	 */
	@PutMapping(path="/Actualizar/{id}")
	public void actualizarTrabajo(@RequestBody Trabajo trabajo, @PathVariable("id") Long id) {
	    Trabajo trabajoObtenido = trabajoRepositorio.findById(id).get();
	    trabajoObtenido.setDescripcion(trabajo.getDescripcion());
	    trabajoObtenido.setEstado(trabajo.isEstado());
	    trabajoObtenido.setHoras(trabajo.getHoras());
	    trabajoRepositorio.save(trabajoObtenido);
	}

	/**
	 * Elimina un Trabajo en concreto mediante el método DELETE.
	 *
	 * @param id Variable por la cual identificaremos el Trabajo.
	 * @return Boolean Devolverá "true" si se ha eliminado correctamente o "false" si ha habido algún problema.
	 */
	@DeleteMapping(path="/Eliminar/{id}")
	public Boolean eliminarTrabajo(@PathVariable("id") Long id) {
	    try {
	        trabajoRepositorio.deleteById(id);
	    } catch (IllegalArgumentException e) {
	        return false;
	    }
	    return true;
	}

}
