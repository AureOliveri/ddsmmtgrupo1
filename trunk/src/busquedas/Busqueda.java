package busquedas;

public class Busqueda {

	/* ATRIBUTOS */

	private String origen;
	private String destino;
	private String fechaV;
	private Opcionales opcionales = new Opcionales();
	
	/* METODOS*/ 
	public Busqueda(String origen,String fecha, String destino, Opcionales opcionales){
		this.setOrigen(origen);
		this.setDestino(destino);
		this.setFechaViaje(fecha);
		this.setOpcionales(opcionales);
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

	public void setOpcionales(Opcionales opcionales) {
		this.opcionales = opcionales;
	}

	public Opcionales getOpcionales() {
		return opcionales;
	}

}
