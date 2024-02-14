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
import edu.apiProyectoJava.bean.Solicitud;
import edu.apiProyectoJava.servicios.AccesoRepositorio;
import edu.apiProyectoJava.servicios.IncidenciaRepositorio;
import edu.apiProyectoJava.servicios.SolicitudRepositorio;

/**
 * Clase que controla las opciones de API y la comunicacion a la base de datos para los Solicitudes
 * 
 * @author Isidro Camacho Diaz
 * 
 * @param SolicitudRepositorio Almacenara la solicitud Al Servidor
 */
@RestController
@RequestMapping("/solicitud")
public class SolicitudController {

	@Autowired
	private SolicitudRepositorio solicitudRepositorio;
	
	/**
	 * Devuelve todas las solicitudes con la petición GET.
	 *
	 * @return Iterable<Solicitud> Objeto que almacena todas las solicitudes.
	 */
	@GetMapping("/Select")
	public Iterable<Solicitud> obtenerSolicitud() {
	    return this.solicitudRepositorio.findAll();
	}

	/**
	 * Devuelve una solicitud en concreto dependiendo del ID insertado con la petición GET.
	 *
	 * @param id Identificación que usaremos para diferenciar otras solicitudes.
	 * @return Optional<Solicitud> Devuelve una colección de solicitud o nulo.
	 */
	@GetMapping(path="/Select/{id}")
	public Optional<Solicitud> obtenerSolicitudID(@PathVariable("id") int id) {
	    return this.solicitudRepositorio.findById(id);
	}

	/**
	 * Inserta una solicitud mediante el método POST.
	 *
	 * @param solicitud Objeto Solicitud a insertar.
	 */
	@PostMapping("/Insertar")
	public void insertarSolicitud(@RequestBody Solicitud solicitud) {
		solicitud.getIncidencia().setSolicitud(solicitud);
	    this.solicitudRepositorio.save(solicitud);	    
	}

	/**
	 * Actualiza una solicitud en concreto por el ID mediante el método PUT.
	 *
	 * @param id       Variable por la cual identificaremos la solicitud.
	 * @param solicitud Solicitud con los datos actualizados.
	 */
	@PutMapping(path="/Actualizar/{id}")
	public void actualizarSolicitud(@RequestBody Solicitud solicitud, @PathVariable("id") int id) {
	    Solicitud solicitudObtenida = solicitudRepositorio.findById(id).get();
	    solicitudObtenida.setDescripcion(solicitud.getDescripcion());
	    solicitudObtenida.setFch_limite(solicitud.getFch_limite());
	    solicitudObtenida.setEstado(solicitud.isEstado());
	    solicitud.getIncidencia().setSolicitud(solicitud);
	    solicitudObtenida.setIncidencia(solicitud.getIncidencia());
	    solicitudRepositorio.save(solicitudObtenida);
	}

	/**
	 * Elimina una solicitud en concreto mediante el método DELETE.
	 *
	 * @param id Variable por la cual identificaremos la solicitud.
	 * @return Boolean Devolverá "true" si se ha eliminado correctamente o "false" si ha habido algún problema.
	 */
	@DeleteMapping(path="/Eliminar/{id}")
	public Boolean eliminarSolicitud(@PathVariable("id") int id) {
	    try {
	        solicitudRepositorio.deleteById(id);
	    } catch (IllegalArgumentException e) {
	        return false;
	    }
	    return true;
	}

}
