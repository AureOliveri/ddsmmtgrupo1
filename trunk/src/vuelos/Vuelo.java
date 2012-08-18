package vuelos;

import java.util.ArrayList;

import aerolineas.Aerolinea;
import aerolineas.AerolineaLanchita;
import busquedas.Busqueda;
import busquedas.Filtro;


public class Vuelo {

	private String horaLlegada;
	private String horaSalida;
	private String origen;
	private String destino;
	private String fechaLlegada;
	private String fechaSalida;
	private String numeroDeVuelo;
	private Aerolinea aerolinea;
	private ArrayList<Asiento> asientos = new ArrayList<Asiento>();
	
	public Vuelo() {}
	
	public Vuelo(String horaLlegada, String horaSalida, String origen,
			String destino, String fechaLlegada, String fechaSalida,
			String numeroDeVuelo, Aerolinea aerolinea) {
		super();
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida;
		this.origen = origen;
		this.destino = destino;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
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
	 
	 public void setFechaSalida(String fechaASetear){
	  this.fechaSalida = fechaASetear;
	 }
	 
	 public void setFechaLlegada(String fechaASetear){
	  this.fechaLlegada = fechaASetear;
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
	 
	 public String getFechaSalida(){
	  return this.fechaSalida;
	 }

	 public String getFechaLlegada(){
	  return this.fechaLlegada;
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
}
