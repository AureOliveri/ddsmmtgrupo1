package main.java.reservas;

import main.java.fechas.Fecha;
import main.java.usuarios.Usuario;
import main.java.vuelos.Asiento;

public class Reserva {

	private Usuario usuario;
	private Fecha fechaVencimiento;
	private Asiento asiento;

	public Reserva(Asiento asiento, Usuario usuario) {
		this.usuario = usuario;
		setAsiento(asiento);
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setFechaVencimiento(Fecha fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Fecha getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setAsiento(Asiento asiento) {
		this.asiento = asiento;
	}

	public Asiento getAsiento() {
		return asiento;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
