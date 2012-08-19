package vuelos;

import java.util.ArrayList;

import fechas.Fecha;

import aerolineas.Aerolinea;


public class Vuelo {

	private String horaLlegada;
	private String horaSalida;
	private String origen;
	private String destino;
	private Fecha fechaLlegada;
	private Fecha fechaSalida;
	private String numeroDeVuelo;
	private Aerolinea aerolinea;
	private ArrayList<Asiento> asientos = new ArrayList<Asiento>();
	
	public Vuelo() {}
	
	public Vuelo(String horaLlegada, String horaSalida, String origen,
			String destino, Fecha fechaLlegada, Fecha fechaSalida,
			String numeroDeVuelo, Aerolinea aerolinea) {
		super();
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida;
		this.origen = origen;
		this.destino = destino;
		this.setFechaLlegada(fechaLlegada);
		this.setFechaSalida(fechaSalida);
		this.numeroDeVuelo = numeroDeVuelo;
		this.aerolinea = aerolinea;
	}

	public boolean yaNoEstasDisponible(Asiento unAsiento) {
		return (unAsiento.getDisponibilidad() == "R");
	}
	
	public void addAsiento(Asiento a) {
		this.asientos.add(a);
	}
	 
	 /* SETTERS*/
	 
	 public void setOrigen(String origenASetear){
	  this.origen = origenASetear;
	 }
	 
	 public void setDestino(String destinoAsetear){
	  this.destino = destinoAsetear;
	 } 
	 
	 public void setHoraSalida(String horaASetear){
	  this.horaSalida = horaASetear;
	 }
	 
	 public void setHoraLlegada(String horaASetear){
	  this.horaLlegada = horaASetear;
	 }

	 public void setNumeroDeVuelo(String numeroDeVuelo) {
			this.numeroDeVuelo = numeroDeVuelo;
	}
	 

	 /*GETTERS*/
	 public String getOrigen(){
	  return this.origen;
	 }
	 
	 public String getDestino(){
	  return this.destino;
	 } 
	 
	 public String getHoraSalida(){
	  return this.horaSalida;
	 }
	 
	 public String getHoraLlegada(){
		 return this.horaLlegada;
	 }

	 public String getNumeroDeVuelo() {
		 return numeroDeVuelo;
	 }

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}

	public void setAsientos(ArrayList<Asiento> asientos) {
		this.asientos = asientos;
	}

	public ArrayList<Asiento> getAsientos() {
		return asientos;
	}

	public void setFechaLlegada(Fecha fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Fecha getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaSalida(Fecha fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Fecha getFechaSalida() {
		return fechaSalida;
	}
}
