package Vuelos;

import java.math.BigDecimal;

public class Asiento {
	
	private String numeroDeVuelo;
	private String numeroDeAsiento;
	private BigDecimal precio;
	private String claseDeAsiento;
	private String ubicacion;
	private String disponibilidad;
	private String codigoAsiento;
	
	public void transformarCodigoANumeroDeAsientoYNumeroDeVuelo(String codigoAsiento){
		this.numeroDeVuelo = this.codigoAsiento.substring(0, 6);
		this.numeroDeAsiento = this.codigoAsiento.substring(7, 9);
	}

	public void ocupate() {
		this.setDisponibilidad("O");
		
	}
	
	/* GETTERS*/
	
	public String getNumeroDeVuelo(){
		return this.numeroDeVuelo;
	}
	public String getNumeroDeAsiento(){
		return this.numeroDeAsiento;
	}
	public BigDecimal getPrecio(){
		return this.precio;
	}
	public String getClaseDeAsiento(){
		return this.claseDeAsiento;
	}
	public String getUbicacion(){
		return this.ubicacion;
	}
	public String getDisponibilidad(){
		return this.disponibilidad;
	}
	/* SETTERS*/
	public void setNumeroDeVuelo(String numVuelo){
		this.numeroDeVuelo = numVuelo;
	}
	public void setNumeroDeAsiento(String numAsiento){
		this.numeroDeAsiento = numAsiento;
	}
	public void setPrecio(BigDecimal unPrecio){
		this.precio =unPrecio;
	}
	public void setClaseDeAsiento(String clasAsiento){
		this.claseDeAsiento = clasAsiento;
	}
	public void setUbicacion(String ubi){
		this.ubicacion = ubi;
	}
	public void setDisponibilidad(String disp){
		this.disponibilidad = disp;
	}
}
