package main.java.busquedas;

import java.util.ArrayList;
import java.util.List;

import main.java.fechas.Fecha;
import main.java.vuelos.Asiento;

import org.uqbar.commons.utils.Observable;


@Observable
public class Busqueda {

	private String origen;
	private String destino;
	private Fecha fechaV;
	private Opcionales opcionales = new Opcionales();
	private List<Asiento> resultado = new ArrayList<Asiento>();
	
	public Busqueda(){
	}
	
	public Busqueda(String origen,Fecha fecha, String destino, Opcionales opcionales){
		this();
		this.setOrigen(origen);
		this.setDestino(destino);
		this.setFechaV(fecha);
		this.setOpcionales(opcionales);
	}


	/* SETTERS*/

	public void setOrigen(String origenASetear){
		this.origen = origenASetear;
	}

	public void setDestino(String destinoAsetear){
		this.destino = destinoAsetear;
	} 

	/*GETTERS*/
	public String getOrigen(){
		return this.origen;
	}

	public String getDestino(){
		return this.destino;
	} 

	public void setOpcionales(Opcionales opcionales) {
		this.opcionales = opcionales;
	}

	public Opcionales getOpcionales() {
		return opcionales;
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
