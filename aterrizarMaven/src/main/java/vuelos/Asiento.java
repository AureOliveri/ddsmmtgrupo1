package main.java.vuelos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.TransactionalAndObservable;

import uqbar.arena.persistence.annotations.PersistentClass;
import uqbar.arena.persistence.annotations.PersistentField;

import main.java.reservas.Reserva;
import main.java.usuarios.TipoUsuario;
import main.java.usuarios.Usuario;
import main.java.usuarios.UsuarioConRecargo;
import main.java.aerolineas.Aerolinea;
import main.java.enumeraciones.Ciudad;
import main.java.enumeraciones.ClaseDeAsiento;
import main.java.enumeraciones.DisponibilidadDeAsiento;
import main.java.enumeraciones.UbicacionDeAsiento;
import main.java.fechas.Fecha;
import main.java.fechas.Hora;

@PersistentClass
@TransactionalAndObservable
public class Asiento extends Entity {

	private ClaseDeAsiento claseDeAsiento;
	private UbicacionDeAsiento ubicacion;
	private Vuelo vuelo;
	private String numeroDeAsiento;
	private String numeroDeVuelo;
	private String codigoAsiento;
	private BigDecimal precioInicial;
	private BigDecimal precioFinal;
	private DisponibilidadDeAsiento disponibilidad;
	private Usuario usuario;
	private Queue<Reserva> reservas;
	private Boolean reservado = false;
	private String dni;
	private Hora horaSalida;
	private Hora horaLlegada;
	private Ciudad origen;
	private Ciudad destino;
	private Fecha fechaSalida;
	private Fecha fechaLlegada;
	private BigDecimal precioConRecargo;

	public Asiento(String codigoAsiento, String precio, String clase,
			String ubicacion, String disponibilidad, String dni,
			String numeroDeAsiento, String numeroDeVuelo, Vuelo vuelo) {
		this();
		setCodigoAsiento(codigoAsiento);
		setPrecioInicial(new BigDecimal(precio));
		setPrecioFinal(precioFinal(vuelo.getAerolinea().getImpuesto()));
		setClaseDeAsiento(ClaseDeAsiento.obtenerClase(clase));
		setUbicacion(UbicacionDeAsiento.obtenerUbicacion(ubicacion));
		setDisponibilidad(DisponibilidadDeAsiento
				.obtenerDisponibilidad(disponibilidad));
		setDni(dni);
		setHoraSalida(vuelo.getHoraSalida());
		setHoraLlegada(vuelo.getHoraLlegada());
		setOrigen(vuelo.getOrigen());
		setDestino(vuelo.getDestino());
		setFechaSalida(vuelo.getFechaSalida());
		setFechaLlegada(vuelo.getFechaLlegada());
		setNumeroDeAsiento(numeroDeAsiento);
		setNumeroDeVuelo(numeroDeVuelo);
		setVuelo(vuelo);
		reservas = new LinkedList<Reserva>();
	}

	public Asiento() {
		super();
	}

	public void mostrar(TipoUsuario tUsuario) {
		TipoUsuario conRecargo = new UsuarioConRecargo();
		if (tUsuario.getCodigo().equals(conRecargo.getCodigo())) {
			System.out.println("         [" + codigoAsiento + ", "
					+ precioConRecargo + ", " + claseDeAsiento.getCodigo()
					+ ", " + ubicacion.getCodigo() + ", "
					+ disponibilidad.getCodigo() + "]");
		} else {
			System.out.println("         [" + codigoAsiento + ", "
					+ precioFinal + ", " + claseDeAsiento.getCodigo() + ", "
					+ ubicacion.getCodigo() + ", " + disponibilidad.getCodigo()
					+ "]");
		}
	}

	public void ocupate() {
		this.setDisponibilidad(DisponibilidadDeAsiento.RESERVADO);
	}

	public boolean esPrimeraClase() {
		return (this.claseDeAsiento.equals(ClaseDeAsiento.PRIMERA));
	}

	public boolean esClaseEjecutiva() {
		return (this.claseDeAsiento.equals(ClaseDeAsiento.EJECUTIVA));
	}

	public boolean esClaseTurista() {
		return (this.claseDeAsiento.equals(ClaseDeAsiento.TURISTA));
	}

	public boolean esSuperOferta() {
		return this.esSuperOfertaPrimera() || this.esSuperOfertaEjecutiva();
	}

	public BigDecimal precioFinal(BigDecimal impuesto) {
		BigDecimal pTotal = precioInicial.add(precioInicial.multiply(impuesto))
				.setScale(2, BigDecimal.ROUND_UP);
		return pTotal;
	}

	public void agregarRecargo(TipoUsuario usuario) {
		this.setPrecioConRecargo(precioFinal.add(usuario.getRecargo()));
	}

	public boolean esOfertaPrimera() {
		BigDecimal ofertaPrimeraClase = new BigDecimal(8000);
		return precioFinal.compareTo(ofertaPrimeraClase) < 0;
	}

	public boolean esOfertaEjecutiva() {
		BigDecimal ofertaClaseEjecutiva = new BigDecimal(4000);
		return precioFinal.compareTo(ofertaClaseEjecutiva) < 0;
	}

	public boolean esSuperOfertaPrimera() {
		return this.esPrimeraClase() && this.esOfertaPrimera();
	}

	public boolean esSuperOfertaEjecutiva() {
		return this.esClaseEjecutiva() && this.esOfertaEjecutiva();
	}

	public ArrayList<String> mostrarAsiento(Asiento unAsiento,
			BigDecimal impuesto, TipoUsuario usuario) {

		ArrayList<String> asientoString = new ArrayList<String>();

		asientoString.add(unAsiento.getCodigoAsiento());
		asientoString.add(unAsiento.getPrecioFinal().toString());
		asientoString.add(unAsiento.getClaseDeAsiento().getCodigo());
		asientoString.add(unAsiento.getUbicacion().getCodigo());
		asientoString.add(unAsiento.getDisponibilidad().getCodigo());

		return asientoString;

	}

	public void expirarReserva() {
		Reserva reserva = this.reservas.poll();
		reserva.getUsuario().getReservas().remove(reserva.getAsiento());
		if (this.reservas.isEmpty()) {
			this.reservado = false;
		}
	}

	public void eliminarReservas() {
		while (this.reservas != null) {
			this.reservas.poll();
		}
	}

	public Boolean noEstaReservado() {
		return (!this.reservado);
	}

	/* GETTERS */

	public Vuelo getVuelo() {
		return vuelo;
	}

	public String getCodigoAsiento() {
		return codigoAsiento;
	}

	public BigDecimal getPrecioInicial() {
		return precioInicial;
	}

	public ClaseDeAsiento getClaseDeAsiento() {
		return claseDeAsiento;
	}

	public UbicacionDeAsiento getUbicacion() {
		return ubicacion;
	}

	public Boolean getReservado() {
		return reservado;
	}

	public Reserva getPrimeraReserva() {
		return reservas.peek();
	}

	public void setPrecioInicial(BigDecimal unPrecio) {
		this.precioInicial = unPrecio;
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

	public Ciudad getOrigen() {
		return origen;
	}

	public void setOrigen(Ciudad origen) {
		this.origen = origen;
	}

	public Ciudad getDestino() {
		return destino;
	}

	public void setDestino(Ciudad destino) {
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

	@PersistentField
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

	@PersistentField
	public String getNumeroDeVuelo() {
		return numeroDeVuelo;
	}

	public void setNumeroDeVuelo(String numeroDeVuelo) {
		this.numeroDeVuelo = numeroDeVuelo;
	}

	public void reservar(Usuario usuario) {
		Reserva reserva = new Reserva(this, usuario);
		this.getReservas().add(reserva);
		if (!this.getReservado()) {
			this.setReservado(true);
		}
	}

	public void setPrecioFinal(BigDecimal precioFinal) {
		this.precioFinal = precioFinal;
	}

	public BigDecimal getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioConRecargo(BigDecimal precioConRecargo) {
		this.precioConRecargo = precioConRecargo;
	}

	public BigDecimal getPrecioConRecargo() {
		return precioConRecargo;
	}

	@Override
	public String toString() {
		return this.codigoAsiento;
	}

	public Aerolinea getAerolinea() {
		return this.vuelo.getAerolinea();
	}

	public String getNombreAerolinea() {
		return this.vuelo.getAerolinea().getNombre();
	}

	public String getFecha() {
		return getFechaSalida().getFechaS();
	}

	private boolean reservaPertenecienteA(Usuario usuario) {
		return estaReservado()
				&& this.getPrimeraReserva().getUsuario().equals(usuario);
	}

	public Boolean estaReservado() {
		return this.getDisponibilidad().equals(
				DisponibilidadDeAsiento.RESERVADO);
	}

	public Boolean estaDisponible() {
		return this.getDisponibilidad().equals(
				DisponibilidadDeAsiento.DISPONIBLE);
	}

	public boolean estaDisponibleParaComprarPor(Usuario usuario) {
		return estaDisponible() || reservaPertenecienteA(usuario);
	}

	public void sobreReservar(Usuario usuario) {
		Reserva reserva = new Reserva(this, usuario);
		this.reservas.add(reserva);
	}
}
