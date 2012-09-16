package main.java.vuelos;

import main.java.fechas.Fecha;

public class Reserva {

	private String dni;
	private Fecha fechaVencimiento;
	private Asiento asiento;

	public Reserva(Asiento asiento, String dni) {
		this.dni = dni;
		setAsiento(asiento);
	}

	public String getDni() {
		return this.dni;
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

	public void setDni(String dni) {
		this.dni = dni;
	}
}
