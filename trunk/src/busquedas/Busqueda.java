package busquedas;

import java.math.BigDecimal;

public class Busqueda {

	/* ATRIBUTOS */

	private String origen;
	private String destino;
	private String fechaV;
	private String claseP;
	private String claseE;
	private String claseT;
	private String ventana;
	private String pasillo;
	private String centro;
	private BigDecimal precioMin;
	private BigDecimal precioMax;
	
	/* METODOS*/ 
	public Busqueda(String origen,String fecha, String destino, String claseP, String claseE, String claseT, 
			String ventana, String pasillo, String centro, BigDecimal precioMin, BigDecimal precioMax){
		this.setOrigen(origen);
		this.setDestino(destino);
		this.setFechaViaje(fecha);
		this.setClaseP(claseP);
		this.setClaseE(claseE);
		this.setClaseT(claseT);
		this.setVentana(ventana);
		this.setPasillo(pasillo);
		this.setCentro(centro);
		this.setPrecioMin(precioMin);
		this.setPrecioMax(precioMax);	
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

	public void setClaseP(String claseP) {
		this.claseP = claseP;
	}

	public void setClaseE(String claseE) {
		this.claseE = claseE;
	}

	public void setClaseT(String claseT) {
		this.claseT = claseT;
	}

	public void setVentana(String ventana) {
		this.ventana = ventana;
	}

	public void setPasillo(String pasillo) {
		this.pasillo = pasillo;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	public void setPrecioMin(BigDecimal precioMin) {
		this.precioMin = precioMin;
	}

	public void setPrecioMax(BigDecimal precioMax) {
		this.precioMax = precioMax;
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

	public String getClaseP() {
		return claseP;
	}

	public String getClaseE() {
		return claseE;
	}

	public String getClaseT() {
		return claseT;
	}

	public String getVentana() {
		return ventana;
	}

	public String getPasillo() {
		return pasillo;
	}

	public String getCentro() {
		return centro;
	}

	public BigDecimal getPrecioMin() {
		return precioMin;
	}

	public BigDecimal getPrecioMax() {
		return precioMax;
	}

}
