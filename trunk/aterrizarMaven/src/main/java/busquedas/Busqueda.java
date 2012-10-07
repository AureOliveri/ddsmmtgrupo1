package main.java.busquedas;

import java.util.ArrayList;
import java.util.List;

import main.java.enumeraciones.Ciudad;
import main.java.fechas.Fecha;
import main.java.vuelos.Asiento;

import org.uqbar.commons.utils.Observable;

@Observable
public class Busqueda {

	private Ciudad origen;
	private Ciudad destino;
	private Fecha fechaV;
	private Opcionales opcionales = new Opcionales();
	private List<Asiento> resultado = new ArrayList<Asiento>();

	public Busqueda(Ciudad origen, Fecha fecha, Ciudad destino,
			Opcionales opcionales) {
		this.setOrigen(origen);
		this.setDestino(destino);
		this.setFechaV(fecha);
		this.setOpcionales(opcionales);
	}

	public void setOrigen(Ciudad origenASetear) {
		this.origen = origenASetear;
	}

	public void setDestino(Ciudad destinoAsetear) {
		this.destino = destinoAsetear;
	}

	public Ciudad getOrigen() {
		return this.origen;
	}

	public Ciudad getDestino() {
		return this.destino;
	}

	public void setOpcionales(Opcionales opcionales) {
		this.opcionales = opcionales;
	}

	public Opcionales getOpcionales() {
		return opcionales;
	}

	public void setFecha(String fecha) {
		Fecha fechaV = new Fecha(fecha);
		setFechaV(fechaV);
	}

	public String getFecha() {
		return getFechaV().getFechaS();
	}

	public void setFechaV(Fecha fechaV) {
		this.fechaV = fechaV;
	}

	public Fecha getFechaV() {
		return fechaV;
	}

	public void setResultado(List<Asiento> resultado) {
		this.resultado = resultado;
	}

	public List<Asiento> getResultado() {
		return resultado;
	}

}
