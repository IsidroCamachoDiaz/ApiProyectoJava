package edu.apiProyectoJava.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.apiProyectoJava.bean.Token;
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
}
