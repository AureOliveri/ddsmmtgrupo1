package main.java.modelos;

import org.uqbar.commons.utils.Observable;

import main.java.usuarios.Usuario;
import main.java.vuelos.Asiento;

@Observable
public class ModeloSobreReserva {
	private Asiento asientoSeleccionado;
	private String mensajeReservado;
	private Usuario usuario;
	
	public ModeloSobreReserva(Asiento asientoSeleccionado, Usuario usuario){
		this.asientoSeleccionado = asientoSeleccionado;
		this.mensajeReservado = "El asiento " + this.asientoSeleccionado.getCodigoAsiento() + " ya se encuentra reservado";
		this.usuario = usuario;
	}
	
	public void setAsientoSeleccionado(Asiento asientoSeleccionado) {
		this.asientoSeleccionado = asientoSeleccionado;
	}

	public Asiento getAsientoSeleccionado() {
		return asientoSeleccionado;
	}

	public void setMensajeReservado(String mensajeReservado) {
		this.mensajeReservado = mensajeReservado;
	}

	public String getMensajeReservado() {
		return mensajeReservado;
	}
	
	public void sobreReservar(){
		this.asientoSeleccionado.sobreReservar(this.usuario);
	}
	
}
