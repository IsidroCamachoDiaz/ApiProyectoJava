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
import edu.apiProyectoJava.servicios.AccesoRepositorio;
import edu.apiProyectoJava.servicios.UsuarioRepositorio;
import edu.apiProyectoJava.bean.Usuario;

/**
 * Clase que controla las opciones de API y la comunicacion a la base de datos para los Usuarios
 * 
 * @author Isidro Camacho Diaz
 * 
 * @param usuarioRepositorio Almacenara el usuario Al Servidor
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	/**
	 * Devuelve todos los Usuarios con la peticion GET
	 * @return Iterable<Usuario> Objeto que almacena todos los usuarios
	 */
	@GetMapping("/Select")
	public Iterable<Usuario> obtenerAcceso() {	
	return this.usuarioRepositorio.findAll();
	}
	
	/**
	  * Devuelve un Usuario en concreto dependiendo del id insertado con la peticion GET
	 * @param id Identificacion que usaremos para diferenciar a otros Usuarios
	 * @return Optional<Usuario> Devuelve una Coleccion de Usuario o nulo 
	 */
	@GetMapping(path="/Select/{id}")
	public Optional<Usuario> obtenerUsuarioID(@PathVariable("id") int id) {	
	return this.usuarioRepositorio.findById(id);
	}
	
	/**
	  * Devuelve un Usuario en concreto dependiendo del correo insertado con la peticion GET
	 * @param correo Identificacion que usaremos para diferenciar a otros Usuarios
	 * @return Optional<Usuario> Devuelve una Coleccion de Usuario o nulo 
	 */
	@GetMapping(path="/SelectCorreo/{correo}")
	public Optional<Usuario> obtenerUsuarioCorreo(@PathVariable("correo") String correo) {	
	return this.usuarioRepositorio.findByCorreo(correo);
	}
	
	/**
	 * Inserta un Usuario por el metodo POST
	 * @param Usuario Objetos Usuario
	 */
	@PostMapping("/Insertar")
	public void insertarUsuario(@RequestBody Usuario usuario) {
		this.usuarioRepositorio.save(usuario);
	}
	
	/**
	 * Actualiza un Usuario en concreto por el id mediante el metodo PUST
	 * @param id Variable por el cual identificaremos el Usuario
	 * @param Usuario usuario
	 */
	@PutMapping(path="/Actualizar/{id}")
	public void actualizarUsuario(@RequestBody Usuario usuario,@PathVariable("id") int id) {
		Usuario usuarioConseguido=usuarioRepositorio.findById(id).get();
		usuarioConseguido.setAcceso(usuario.getAcceso());
		usuarioConseguido.setContrasenia(usuario.getContrasenia());
		usuarioConseguido.setCorreo(usuario.getCorreo());
		usuarioConseguido.setFoto(usuario.getFoto());
		usuarioConseguido.setNombre(usuario.getNombre());
		usuarioConseguido.setTelefono(usuario.getTelefono());
		usuarioRepositorio.save(usuarioConseguido);
	}
	
	/**
	  * Eliminar un Usuario en concreto mediante el metodo DELETE
	 * @param id Variable por el cual identificaremos el Usuario
	 * @return Boolean Devolvera "true" si se a Eliminado correctamente o "false" si a habido algun problema
	 */
	@DeleteMapping(path="/Eliminar/{id}")
	public Boolean eliminarUsuario(@PathVariable("id") int id) {
		try {
			usuarioRepositorio.deleteById(id);
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		return true;
	}

}
