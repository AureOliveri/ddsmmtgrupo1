package vuelos;

import java.math.BigDecimal;
import java.util.ArrayList;

import usuarios.TipoUsuario;
import usuarios.Usuario;


import enumeraciones.ClaseDeAsiento;
import enumeraciones.UbicacionDeAsiento;

import java.util.Queue;

public class Asiento {
	
	private ClaseDeAsiento claseDeAsiento;
	private UbicacionDeAsiento ubicacion;
	private Vuelo vuelo;
	private BigDecimal numeroDeAsiento;
	private String codigoAsiento;
	private BigDecimal precio;
	private String disponibilidad;
	private Usuario usuario;
	private Queue<Reserva> reservas;
	private Boolean reservado = false;
	
	public Asiento(String[] asiento) {
		this();
		this.setCodigoAsiento(asiento[0]);
		this.precio = new BigDecimal(asiento[1]);
		this.disponibilidad = asiento[4];
		this.claseDeAsiento = ClaseDeAsiento.obtenerClase(asiento[2]);
		this.ubicacion = UbicacionDeAsiento.obtenerUbicacion(asiento[3]);
		
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
		return (this.claseDeAsiento.equals(ClaseDeAsiento.PRIMERA));
	}
	
	public boolean esClaseEjecutiva(){
		return (this.claseDeAsiento.equals(ClaseDeAsiento.EJECUTIVA));
	}
	
	public boolean esClaseTurista(){
		return (this.claseDeAsiento.equals(ClaseDeAsiento.TURISTA));
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
		return this.precioTotal(impuesto, usuario).compareTo(ofertaPrimeraClase) < 0;
	}

	public boolean esOfertaEjecutiva(BigDecimal impuesto, TipoUsuario usuario) {
		BigDecimal ofertaClaseEjecutiva = new BigDecimal(4000);
		return this.precioTotal(impuesto, usuario).compareTo(ofertaClaseEjecutiva) < 0;
	}
	
	public boolean esSuperOfertaPrimera(BigDecimal impuesto, TipoUsuario usuario) {
		return this.esPrimeraClase() && this.esOfertaPrimera(impuesto, usuario);
	}
	
	public boolean esSuperOfertaEjecutiva(BigDecimal impuesto, TipoUsuario usuario) {
		return this.esClaseEjecutiva() && this.esOfertaEjecutiva(impuesto, usuario);
	}
	
	public ArrayList<String> mostrarAsiento(Asiento unAsiento, BigDecimal impuesto, TipoUsuario usuario) {
		
		ArrayList<String> asientoString = new ArrayList<String>();
		
		asientoString.add(unAsiento.getCodigoAsiento());
		asientoString.add(unAsiento.precioTotal(impuesto, usuario).toString());
		asientoString.add(unAsiento.getClaseDeAsiento().getCodigo());
		asientoString.add(unAsiento.getUbicacion().getCodigo());
		asientoString.add(unAsiento.getDisponibilidad());

		return asientoString;

	}
	
	public void reservar(String dni){
		Reserva nuevaReserva = new Reserva(this.codigoAsiento, dni);
		this.reservas.add(nuevaReserva);
		this.reservado = true;
	}
	
	public void expirarReserva(){
		this.reservas.poll();
		if(this.reservas.isEmpty()){
			this.reservado = false;
		}
	}
	
	public void eliminarReservas(){
		while (this.reservas != null){
			this.reservas.poll();
		}
	}
	
	public Boolean noEstaReservado(){
		return (!this.reservado);
	}
	
	/* GETTERS*/

	public Vuelo getVuelo() {
		return vuelo;
	}
	public BigDecimal getNumeroDeAsiento() {
		return numeroDeAsiento;
	}
	public String getCodigoAsiento() {
		return codigoAsiento;
	}
	public BigDecimal getPrecio(){
		return this.precio;
	}
	public ClaseDeAsiento getClaseDeAsiento(){
		return this.claseDeAsiento;
	}
	public UbicacionDeAsiento getUbicacion(){
		return this.ubicacion;
	}
	public String getDisponibilidad(){
		return this.disponibilidad;
	}
	
	public Boolean getReservado(){
		return this.reservado;
	}
	
	public Reserva getPrimeraReserva(){
		return this.reservas.peek();
	}
	
	/* SETTERS*/
	
	
	public void setPrecio(BigDecimal unPrecio){
		this.precio =unPrecio;
	}
	public void setDisponibilidad(String disp){
		this.disponibilidad = disp;
	}
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	public void setNumeroDeAsiento(BigDecimal numeroDeAsiento) {
		this.numeroDeAsiento = numeroDeAsiento;
	}
	public void setCodigoAsiento(String codigoAsiento) {
		this.codigoAsiento = codigoAsiento;
	}
}
