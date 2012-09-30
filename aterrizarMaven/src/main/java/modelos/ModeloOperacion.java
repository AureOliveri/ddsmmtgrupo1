package main.java.modelos;


import main.java.usuarios.Usuario;
import main.java.usuarios.UsuarioVIP;

import org.uqbar.commons.utils.Observable;


@Observable
public class ModeloOperacion {
	
	private Usuario usuario = new Usuario("Señor Usuario", "35555555", new UsuarioVIP());
	private String saludo;
	private String label;
	
	public ModeloOperacion() {
		this.saludo = "Hola " + this.usuario.getNombre();
	}
	
	public ModeloOperacion(String label) {
		this.label = (label + " de " + this.usuario.getNombre());
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public String getSaludo() {
		return saludo;
	}

	public String getLabel() {
		return label;
	}
	
 
}
