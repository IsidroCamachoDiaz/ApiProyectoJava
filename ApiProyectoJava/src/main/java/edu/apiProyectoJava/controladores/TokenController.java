package edu.apiProyectoJava.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.apiProyectoJava.bean.Token;
import edu.apiProyectoJava.bean.Usuario;
import edu.apiProyectoJava.servicios.TokenRepositorio;

/**
 * Clase que controla las opciones de API y la comunicacion a la base de datos para los Tokens
 * 
 * @author Isidro Camacho Diaz
 * 
 * @param usuarioRepositorio Almacenara el token Al Servidor
 */
@RestController
@RequestMapping("/token")
public class TokenController {
	
	@Autowired
	private TokenRepositorio tokenServicio;
	
	/**
	  * Devuelve un Token en concreto dependiendo del id insertado con la peticion GET
	 * @param token Identificacion que usaremos para diferenciar a otros Tokens
	 * @return Optional<Token> Devuelve una Coleccion de Token o nulo 
	 */
	@GetMapping(path="/Select/{token}")
	public Optional<Token> getToken(@PathVariable("token") String token) {	
		return tokenServicio.findByToken(token);
	}
	
	/**
	 * Inserta Un Token en basa de datos
	 * @param token usaremos para insertar
	 */
	
	@PostMapping("/Insertar")
	public void insertarToken(@RequestBody Token token) {
		this.tokenServicio.save(token);
	}
	/**
	 * Da todos los tokens
	 * @return todos los tokens
	 */
	@GetMapping("/Select")
	public Iterable<Token> obtenerAcceso() {	
	return this.tokenServicio.findAll();
	}
	
	/**
	  * Eliminar un token en concreto mediante el metodo DELETE
	 * @param id Variable por el cual identificaremos el Usuario
	 * @return Boolean Devolvera "true" si se a Eliminado correctamente o "false" si a habido algun problema
	 */
	@DeleteMapping(path="/Eliminar/{id}")
	public Boolean eliminarToken(@PathVariable("id") int id) {
		try {
			tokenServicio.deleteById(id);
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		return true;
	}
}
