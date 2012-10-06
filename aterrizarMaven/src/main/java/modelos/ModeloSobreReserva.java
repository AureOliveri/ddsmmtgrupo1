package main.java.modelos;

import main.java.vuelos.Asiento;

public class ModeloSobreReserva {
	private Asiento asientoSeleccionado;
	private String mensajeReservado;

	public ModeloSobreReserva(Asiento asientoSeleccionado){
		this.asientoSeleccionado = asientoSeleccionado;
		this.mensajeReservado = "El asiento " + this.asientoSeleccionado.getCodigoAsiento() + " ya se encuentra reservado";
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
	
}
