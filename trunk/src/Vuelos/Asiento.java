package Vuelos;

import java.math.BigDecimal;

import Usuarios.Usuario;


public class Asiento {
	
	private String numeroDeVuelo;
	private String numeroDeAsiento;
	private BigDecimal precio;
	private String claseDeAsiento;
	private String ubicacion;
	private String disponibilidad;
	private String codigoAsiento;
	private Usuario usuario;
	
	public void transformarCodigoANumeroDeAsientoYNumeroDeVuelo(String codigoAsiento){
		this.numeroDeVuelo = this.codigoAsiento.substring(0, 6);
		this.numeroDeAsiento = this.codigoAsiento.substring(7, 9);
	}

	public void ocupate() {
		this.setDisponibilidad("O");
		
	}

	public boolean esPrimeraClase(){
		return (claseDeAsiento == "primera");
	}
	
	public boolean esClaseEjecutiva(){
		return (claseDeAsiento == "ejecutivo");
	}
	
	public boolean esClaseTurista(){
		return (claseDeAsiento == "turista");
	}
	
	public boolean esSuperOferta(BigDecimal impuesto){
		return (this.esSuperOfertaPrimera(impuesto) || this.esSuperOfertaEjecutiva(impuesto)); 
	}
	
	private BigDecimal precioTotal(BigDecimal impuesto) {
		precio.add(usuario.getRecargo());
		return precio.add(precio.multiply(impuesto));	
	}
	
	public boolean esOfertaPrimera(BigDecimal impuesto) {
		BigDecimal ofertaPrimeraClase = new BigDecimal(8000);
		return this.precioTotal(impuesto).compareTo(ofertaPrimeraClase) < 0;
	}

	public boolean esOfertaEjecutiva(BigDecimal impuesto) {
		BigDecimal ofertaClaseEjecutiva = new BigDecimal(4000);
		return this.precioTotal(impuesto).compareTo(ofertaClaseEjecutiva) < 0;
	}
	
	public boolean esSuperOfertaPrimera(BigDecimal impuesto) {
		return this.esPrimeraClase() && this.esOfertaPrimera(impuesto);
	}
	
	public boolean esSuperOfertaEjecutiva(BigDecimal impuesto) {
		return this.esClaseEjecutiva() && this.esOfertaEjecutiva(impuesto);
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
