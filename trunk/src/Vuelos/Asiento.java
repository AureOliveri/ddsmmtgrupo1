package Vuelos;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import Usuarios.TipoUsuario;
import Usuarios.Usuario;
import Usuarios.UsuarioVIP;


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
		return (claseDeAsiento == "P");
	}
	
	public boolean esClaseEjecutiva(){
		return (claseDeAsiento == "E");
	}
	
	public boolean esClaseTurista(){
		return (claseDeAsiento == "T");
	}
	
	public boolean esSuperOferta(BigDecimal impuesto, TipoUsuario usuario){
		return (this.esSuperOfertaPrimera(impuesto, usuario) || this.esSuperOfertaEjecutiva(impuesto, usuario)); 
	}
	
	public BigDecimal precioTotal(BigDecimal impuesto, TipoUsuario usuario) {
		BigDecimal pTotal = precio.add(precio.multiply(impuesto)).setScale(2, BigDecimal.ROUND_UP);
		pTotal = pTotal.add(usuario.getRecargo());
		return pTotal;	
	}
	
	public boolean esOfertaPrimera(BigDecimal impuesto, TipoUsuario usuario) {
		BigDecimal ofertaPrimeraClase = new BigDecimal(8000);
		return this.precioTotal(impuesto, usuario).compareTo(ofertaPrimeraClase) > 0;
	}

	public boolean esOfertaEjecutiva(BigDecimal impuesto, TipoUsuario usuario) {
		BigDecimal ofertaClaseEjecutiva = new BigDecimal(4000);
		return this.precioTotal(impuesto, usuario).compareTo(ofertaClaseEjecutiva) > 0;
	}
	
	public boolean esSuperOfertaPrimera(BigDecimal impuesto, TipoUsuario usuario) {
		return this.esPrimeraClase() && this.esOfertaPrimera(impuesto, usuario);
	}
	
	public boolean esSuperOfertaEjecutiva(BigDecimal impuesto, TipoUsuario usuario) {
		return this.esClaseEjecutiva() && this.esOfertaEjecutiva(impuesto, usuario);
	}
	


	public ArrayList<String> mostrarAsiento(Asiento unAsiento, BigDecimal impuesto, TipoUsuario usuario) {
		
		ArrayList<String> asientoString = new ArrayList<String>();
		
		asientoString.add(unAsiento.getCodigoDeAsiento());
		asientoString.add(unAsiento.precioTotal(impuesto, usuario).toString());
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
