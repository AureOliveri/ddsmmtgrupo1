package busquedas;

public class Busqueda {
	
	/* ATRIBUTOS */
	
	private String origen;
	private String destino;
	private String fechaV;
	
	
	/* METODOS*/ 
	public Busqueda(String origen,String fecha, String destino){
		this.setOrigen(origen);
		this.setDestino(destino);
		this.setFechaViaje(fecha);
	}


	
	
	/* SETTERS*/
	 
	 public void setOrigen(String origenASetear){
	  this.origen = origenASetear;
	 }
	 
	 public void setDestino(String destinoAsetear){
	  this.destino = destinoAsetear;
	 } 
	 
	 public void setFechaViaje(String fechaASetear){
	  this.fechaV = fechaASetear;
	 }


	 /*GETTERS*/
	 public String getOrigen(){
	  return this.origen;
	 }
	 
	 public String getDestino(){
	  return this.destino;
	 } 
	 
	 public String getFechaViaje(){
	  return this.fechaV;
	 }

}
