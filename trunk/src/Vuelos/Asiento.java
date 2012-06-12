package Vuelos;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import Usuarios.Usuario;


public class Asiento {
	
	private BigDecimal precio;
	private String claseDeAsiento;
	private String ubicacion;
	private String disponibilidad;
	private String codigoAsiento;
	private Usuario usuario;
	
	public Asiento(String[] asiento) {
		this();
		this.codigoAsiento = asiento[0];
		this.precio = new BigDecimal(asiento[1]);
		this.claseDeAsiento = asiento[2];
		this.ubicacion = asiento[3];
		this.disponibilidad = asiento[4];
	}

	public Asiento() {
		super();
	}
	
	public void imprimir(){
		System.out.println(this.ubicacion);
	}
	

	public void ocupate() {
		this.setDisponibilidad("R");
		
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
	


	public ArrayList<String> mostrarAsiento(Asiento unAsiento){
		
		ArrayList<String> asientoString = new ArrayList<String>();
		
		asientoString.add(unAsiento.getCodigoDeAsiento());
		asientoString.add(unAsiento.getPrecio().toString());
		asientoString.add(unAsiento.getClaseDeAsiento());
		asientoString.add(unAsiento.getUbicacion());
		asientoString.add(unAsiento.getDisponibilidad());

		return asientoString;

	}
	
	
	

	/* GETTERS*/
	
	public String getCodigoDeAsiento() {
		return this.codigoAsiento;
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
