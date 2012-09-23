package main.java.usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.TransactionalAndObservable;

import main.java.excepciones.AsientoReservadoException;
import main.java.vuelos.Asiento;
import main.java.busquedas.Busqueda;

@TransactionalAndObservable
public class Usuario extends Entity {

	private String nombre;
	private String dni;
	protected TipoUsuario tipoUsuario;
	protected BigDecimal recargo = new BigDecimal(20);
	private BigDecimal montoCompras = new BigDecimal(0);
	private ArrayList<Busqueda> historialBusquedas = new ArrayList<Busqueda>();
	private ArrayList<Asiento> reservas = new ArrayList<Asiento>();

	public Usuario(){
	}
	
	public Usuario(String nombre, String dni, TipoUsuario tipo) {
		this();		
		setNombre(nombre);
		setDni(dni);
		setTipoUsuario(tipo);
	}
	
	public ArrayList<Asiento> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<Asiento> reservas) {
		this.reservas = reservas;
	}

	public void comprarAsiento(Asiento unAsiento) {
		try {
			this.tipoUsuario.comprarAsiento(unAsiento, this.getDni());
			this.reservas.add(unAsiento);
		} catch (AsientoReservadoException e) {
		
		}

	}

	public Boolean noTieneReserva(Asiento unAsiento) {
		return !(this.getReservas().contains(unAsiento));
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public BigDecimal getRecargo() {
		return recargo;
	}

	public ArrayList<Busqueda> getHistorial() {
		return historialBusquedas;
	}

	public void setMontoCompras(BigDecimal montoCompras) {
		this.montoCompras = montoCompras;
	}

	public BigDecimal getMontoCompras() {
		return montoCompras;
	}

	public void guardarBusqueda(Busqueda busqueda) {
		historialBusquedas.add(busqueda);
	}

	public ArrayList<Asiento> getAsientosQueLeCorreponden(
			ArrayList<Asiento> asientos, TipoUsuario usuario) {

		return this.tipoUsuario.getAsientosQueLeCorresponden(asientos, usuario);

	}

	public void setTipoUsuario(TipoUsuario tipo) {
		this.tipoUsuario = tipo;

	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDni() {
		return dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
}
