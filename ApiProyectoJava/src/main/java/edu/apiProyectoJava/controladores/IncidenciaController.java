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
import edu.apiProyectoJava.bean.Incidencia;
import edu.apiProyectoJava.servicios.AccesoRepositorio;
import edu.apiProyectoJava.servicios.IncidenciaRepositorio;

/**
 * Clase que controla las opciones de API y la comunicacion a la base de datos para las Incidencias
 * 
 * @author Isidro Camacho Diaz
 * 
 * @param IncidenciaReporsitorio Almacenara la incidencia Al Servidor
 */
@RestController
@RequestMapping("/incidencia")
public class IncidenciaController {


	@Autowired
	private IncidenciaRepositorio incidenciaRepositorio;
	/**
	 * Devuelve todas las incidencias con la petición GET.
	 *
	 * @return Iterable<Incidencia> Objeto que almacena todas las incidencias.
	 */
	@GetMapping("/Select")
	public Iterable<Incidencia> obtenerIncidencia() {	
	    return this.incidenciaRepositorio.findAll();
	}

	/**
	 * Devuelve una incidencia en concreto dependiendo del ID insertado con la petición GET.
	 *
	 * @param id Identificación que usaremos para diferenciar otras incidencias.
	 * @return Optional<Incidencia> Devuelve una colección de incidencia o nulo.
	 */
	@GetMapping(path="/Select/{id}")
	public Optional<Incidencia> obtenerIncidenciaID(@PathVariable("id") Long id) {	
	    return this.incidenciaRepositorio.findById(id);
	}

	/**
	 * Inserta una incidencia mediante el método POST.
	 *
	 * @param incidencia Objeto Incidencia a insertar.
	 */
	@PostMapping("/Insertar")
	public void insertarIncidencia(@RequestBody Incidencia incidencia) {
	    this.incidenciaRepositorio.save(incidencia);
	}

	/**
	 * Actualiza una incidencia en concreto por el ID mediante el método PUT.
	 *
	 * @param id        Variable por la cual identificaremos la incidencia.
	 * @param incidencia Incidencia con los datos actualizados.
	 */
	@PutMapping(path="/Actualizar/{id}")
	public void actualizarIncidencia(@RequestBody Incidencia incidencia, @PathVariable("id") Long id) {
	    Incidencia incidenciaObtenida = incidenciaRepositorio.findById(id).get();
	    incidenciaObtenida.setCoste(incidencia.getCoste());
	    incidenciaObtenida.setEmpleado(incidencia.getEmpleado());
	    incidenciaObtenida.setFecha_fin(incidencia.getFecha_fin());
	    incidenciaObtenida.setFecha_inicio(incidencia.getFecha_inicio());
	    incidenciaObtenida.setHoras(incidencia.getHoras());
	    incidenciaObtenida.setSolicitud(incidencia.getSolicitud());
	    incidenciaObtenida.setDescripcion_tecnica(incidencia.getDescripcion_tecnica());
	    incidenciaObtenida.setDescripcion_usuario(incidencia.getDescripcion_usuario());
	    incidenciaObtenida.setEstado(incidencia.isEstado());
	    incidenciaRepositorio.save(incidenciaObtenida);
	}

	/**
	 * Elimina una incidencia en concreto mediante el método DELETE.
	 *
	 * @param id Variable por la cual identificaremos la incidencia.
	 * @return Boolean Devolverá "true" si se ha eliminado correctamente o "false" si ha habido algún problema.
	 */
	@DeleteMapping(path="/Eliminar/{id}")
	public Boolean eliminarIncidencia(@PathVariable("id") Long id) {
	    try {
	        incidenciaRepositorio.deleteById(id);
	    } catch (IllegalArgumentException e) {
	        return false;
	    }
	    return true;
	}

}
