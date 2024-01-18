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

import edu.apiProyectoJava.bean.Solicitud;
import edu.apiProyectoJava.bean.TipoIncidencia;
import edu.apiProyectoJava.servicios.SolicitudRepositorio;
import edu.apiProyectoJava.servicios.TipoIncidenciaRepositorio;

/**
 * Clase que controla las opciones de API y la comunicacion a la base de datos para los Tipos Incidencias
 * 
 * @author Isidro Camacho Diaz
 * 
 * @param TipoIncidenciaRepositorio Almacenara la solicitud Al Servidor
 */
@RestController
@RequestMapping("/tipo_incidencia")
public class TipoIncidenciaController {

	@Autowired
	private TipoIncidenciaRepositorio tipoIncidenciaRepositorio;
	
	/**
	 * Devuelve todos los tipos de incidencias con la petición GET.
	 *
	 * @return Iterable<TipoIncidencia> Objeto que almacena todos los tipos de incidencias.
	 */
	@GetMapping("/Select")
	public Iterable<TipoIncidencia> obtenerTiposIncidencias() {
	    return this.tipoIncidenciaRepositorio.findAll();
	}

	/**
	 * Devuelve un tipo de incidencia en concreto dependiendo del ID insertado con la petición GET.
	 *
	 * @param id Identificación que usaremos para diferenciar otros tipos de incidencias.
	 * @return Optional<TipoIncidencia> Devuelve una colección de tipo de incidencia o nulo.
	 */
	@GetMapping(path="/Select/{id}")
	public Optional<TipoIncidencia> obtenerTipoIncidenciaID(@PathVariable("id") Long id) {
	    return this.tipoIncidenciaRepositorio.findById(id);
	}

	/**
	 * Inserta un tipo de incidencia mediante el método POST.
	 *
	 * @param tipoIncidencia Objeto TipoIncidencia a insertar.
	 */
	@PostMapping("/Insertar")
	public void insertarTipoIncidencia(@RequestBody TipoIncidencia tipoIncidencia) {
	    this.tipoIncidenciaRepositorio.save(tipoIncidencia);
	}

	/**
	 * Actualiza un tipo de incidencia en concreto por el ID mediante el método PUT.
	 *
	 * @param id              Variable por la cual identificaremos el tipo de incidencia.
	 * @param tipoIncidencia  TipoIncidencia con los datos actualizados.
	 */
	@PutMapping(path="/Actualizar/{id}")
	public void actualizarTipoIncidencia(@RequestBody TipoIncidencia tipoIncidencia, @PathVariable("id") Long id) {
	    TipoIncidencia tipoIncidenciaObtenido = tipoIncidenciaRepositorio.findById(id).get();
	    tipoIncidenciaObtenido.setDescripcion_tipo(tipoIncidencia.getDescripcion_tipo());
	    tipoIncidenciaObtenido.setFecha_fin(tipoIncidencia.getFecha_fin());
	    tipoIncidenciaRepositorio.save(tipoIncidenciaObtenido);
	}


}
