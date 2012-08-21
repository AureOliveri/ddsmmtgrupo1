package vuelos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Queue;


import usuarios.TipoUsuario;
import usuarios.Usuario;
import enumeraciones.ClaseDeAsiento;
import enumeraciones.DisponibilidadDeAsiento;
import enumeraciones.UbicacionDeAsiento;
import fechas.Fecha;
import fechas.Hora;

public class Asiento {
	
	private ClaseDeAsiento claseDeAsiento;
	private UbicacionDeAsiento ubicacion;
	private Vuelo vuelo;
	private String numeroDeAsiento;
	private String numeroDeVuelo;
	private String codigoAsiento;
	private BigDecimal precio;
	private DisponibilidadDeAsiento disponibilidad;
	private Usuario usuario;
	private Queue<Reserva> reservas;
	private Boolean reservado = false;
	private String dni;
	private Hora horaSalida;
	private Hora horaLlegada;
	private String origen;
	private String destino;
	private Fecha fechaSalida;
	private Fecha fechaLlegada;
	
	public Asiento(String[] asiento) {
		this();
		this.setCodigoAsiento(asiento[0]);
		precio = new BigDecimal(asiento[1]);
		claseDeAsiento = ClaseDeAsiento.obtenerClase(asiento[2]);
		ubicacion = UbicacionDeAsiento.obtenerUbicacion(asiento[3]);
		setDisponibilidad(DisponibilidadDeAsiento.obtenerDisponibilidad(asiento[4]));
		dni = asiento[5];
		setHoraSalida(new Hora(asiento[6]));
		setHoraLlegada(new Hora(asiento[7]));
		origen = asiento[8];
		destino = asiento[9];
		setFechaSalida(new Fecha(asiento[10]));
		setFechaLlegada(new Fecha(asiento[11]));
		setNumeroDeAsiento(asiento[12]);
		setNumeroDeVuelo(asiento[13]);
	}

	public Asiento() {
		super();
	}
	
	public void imprimir(){
		System.out.println(this.ubicacion);
	}
	
	public void ocupate() {
		this.setDisponibilidad(DisponibilidadDeAsiento.RESERVADO);
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
		asientoString.add(unAsiento.getDisponibilidad().getCodigo());

		return asientoString;

	}
	
	public void reservar(String dni){
		Reserva nuevaReserva = new Reserva(this, dni);
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

	public String getCodigoAsiento() {
		return codigoAsiento;
	}
	public BigDecimal getPrecio(){
		return precio;
	}
	public ClaseDeAsiento getClaseDeAsiento(){
		return claseDeAsiento;
	}
	public UbicacionDeAsiento getUbicacion(){
		return ubicacion;
	}
	
	public Boolean getReservado(){
		return reservado;
	}
	
	public Reserva getPrimeraReserva(){
		return reservas.peek();
	}
	
	
	/* SETTERS*/
	
	
	public void setPrecio(BigDecimal unPrecio){
		this.precio =unPrecio;
	}
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	public void setCodigoAsiento(String codigoAsiento) {
		this.codigoAsiento = codigoAsiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Queue<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Queue<Reserva> reservas) {
		this.reservas = reservas;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public void setClaseDeAsiento(ClaseDeAsiento claseDeAsiento) {
		this.claseDeAsiento = claseDeAsiento;
	}

	public void setUbicacion(UbicacionDeAsiento ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void setReservado(Boolean reservado) {
		this.reservado = reservado;
	}
	
	public void setFechaSalida(Fecha fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Fecha getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaLlegada(Fecha fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Fecha getFechaLlegada() {
		return fechaLlegada;
	}

	public void setDisponibilidad(DisponibilidadDeAsiento disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public DisponibilidadDeAsiento getDisponibilidad() {
		return disponibilidad;
	}

	public Hora getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Hora horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Hora getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(Hora horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public String getNumeroDeAsiento() {
		return numeroDeAsiento;
	}

	public void setNumeroDeAsiento(String numeroDeAsiento) {
		this.numeroDeAsiento = numeroDeAsiento;
	}

	public String getNumeroDeVuelo() {
		return numeroDeVuelo;
	}

	public void setNumeroDeVuelo(String numeroDeVuelo) {
		this.numeroDeVuelo = numeroDeVuelo;
	}
	
}
