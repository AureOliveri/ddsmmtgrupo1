package main.java.modelos;

import main.java.usuarios.Usuario;
import main.java.usuarios.UsuarioVIP;

import org.uqbar.commons.utils.Observable;


@Observable
public class ModeloPrincipal {
	
	private Usuario usuario = new Usuario("Señor Usuario", "35555555", new UsuarioVIP());
	private String saludo;
	
	public ModeloPrincipal() {
		this.saludo = "Hola " + this.usuario.getNombre();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public String getSaludo() {
		return saludo;
	}

}
