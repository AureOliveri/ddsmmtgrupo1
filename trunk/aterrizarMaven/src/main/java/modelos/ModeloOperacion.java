package main.java.modelos;


import java.util.List;

import main.java.usuarios.Usuario;
import main.java.vuelos.Asiento;

import org.uqbar.commons.utils.Observable;


@Observable
public class ModeloOperacion {
	
	private Usuario usuario;
	private Asiento asientoSeleccionado;
	private String saludo;
	private String label;
	private List<Asiento> resultados;
	
	public ModeloOperacion(String label, Usuario usuario) {
		this.usuario = usuario;
		this.label = (label + " de " + this.usuario.getNombre());
		if (label.equals("Reservas")) {
			this.setResultados(this.usuario.getReservas());
		} else {
			this.setResultados(this.usuario.getCompras());
		}
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

	public void setAsientoSeleccionado(Asiento asientoSeleccionado) {
		this.asientoSeleccionado = asientoSeleccionado;
	}

	public Asiento getAsientoSeleccionado() {
		return asientoSeleccionado;
	}



	public void setResultados(List<Asiento> resultados) {
		this.resultados = resultados;
	}

	public List<Asiento> getResultados() {
		return resultados;
	}
	
 
}
