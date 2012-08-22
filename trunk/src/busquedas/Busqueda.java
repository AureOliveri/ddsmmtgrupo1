package busquedas;

import java.util.ArrayList;

import fechas.Fecha;

public class Busqueda {

	/* ATRIBUTOS */

	private String origen;
	private String destino;
	private Fecha fechaV;
	private Opcionales opcionales = new Opcionales();
	private ArrayList<ArrayList<String>> resultado = new ArrayList<ArrayList<String>>();
	
	
	/* METODOS*/ 
	public Busqueda(String origen,Fecha fecha, String destino, Opcionales opcionales){
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


	public void setResultado(ArrayList<ArrayList<String>> resultado) {
		this.resultado = resultado;
	}
	
	public ArrayList<ArrayList<String>> getResultado() {
		return resultado;
	}

}
