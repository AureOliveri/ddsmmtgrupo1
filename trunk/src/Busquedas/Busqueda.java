package Busquedas;

public class Busqueda {
	
	/* ATRIBUTOS */
	
	private String origen;
	private String fechaSalida;
	private String destino;
	private String fechaLlegada;
	
	
	/* METODOS*/ 
	public Busqueda(String origen,String fechaSalida, String destino, String fechaLlegada){
		this.setOrigen(origen);
		this.setFechaSalida(fechaSalida);		
		this.setDestino(destino);
		this.setFechaLlegada(fechaLlegada);
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

}
