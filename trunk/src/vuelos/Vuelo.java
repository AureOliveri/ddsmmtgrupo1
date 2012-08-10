package vuelos;

import java.util.ArrayList;

import busquedas.Busqueda;


public class Vuelo {

	private String origen;
	private String fechaSalida;
	private String horaSalida;
	private String destino;
	private String fechaLlegada;
	private String horaLlegada;
	private String numeroDeVuelo;
	private ArrayList<Asiento> asientos = new ArrayList<Asiento>();
	
	public Vuelo(){
		
	}

	public boolean yaNoEstasDisponible(Asiento unAsiento) {
		return (unAsiento.getDisponibilidad() == "R");
		
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
}
