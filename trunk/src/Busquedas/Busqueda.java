package Busquedas;

import java.util.ArrayList;

public class Busqueda {
	
	/* ATRIBUTOS */
	
	ArrayList<String> resultado;
	private String origen;
	private String fechaSalida;
	private String horaSalida;
	private String destino;
	private String fechaLlegada;
	private String horaLlegada;
	
	
	/* METODOS*/ 
	public Busqueda(String origen,String fechaSalida, String horaSalida, String destino, String fechaLlegada, String horaLlegada){
		this.setOrigen(origen);
		this.setFechaSalida(fechaSalida);
		this.setHoraSalida(horaLlegada);
		this.setDestino(destino);
		this.setFechaLlegada(fechaLlegada);
		this.setHoraLlegada(horaLlegada);
	}
	
	public ArrayList<ArrayList<String>> resultadoDeBusqueda(String unOrigen, String unDestino,
			String unaFechaDeSalida, String unaFechaDeLlegada){
				return null;
		
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
}
