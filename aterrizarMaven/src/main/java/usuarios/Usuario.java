package main.java.usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.TransactionalAndObservable;

import main.java.enumeraciones.DisponibilidadDeAsiento;
import main.java.excepciones.AsientoReservadoException;
import main.java.vuelos.Asiento;
import main.java.busquedas.Busqueda;

@TransactionalAndObservable
public class Usuario extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String dni;
	protected TipoUsuario tipoUsuario;
	protected BigDecimal recargo = new BigDecimal(20);
	private BigDecimal montoCompras = new BigDecimal(0);
	private ArrayList<Busqueda> historialBusquedas = new ArrayList<Busqueda>();
	private List<Asiento> compras = new ArrayList<Asiento>();
	private List<Asiento> reservas = new ArrayList<Asiento>();

	public Usuario(){
	}
	
	public Usuario(String nombre, String dni, TipoUsuario tipo) {
		this();		
		setNombre(nombre);
		setDni(dni);
		setTipoUsuario(tipo);
	}
	
	public List<Asiento> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<Asiento> reservas) {
		this.reservas = reservas;
	}

	public void comprarAsiento(Asiento unAsiento) {
		try {
			this.tipoUsuario.comprarAsiento(unAsiento, this.getDni());
			this.getCompras().add(unAsiento);
		} catch (AsientoReservadoException e) {
			throw new UserException("Asiento reservado");
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
	
	public void comprar(Asiento asiento){
		if(asiento.estasDisponiblePAra(this))	this.compras.add(asiento);			
	
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
	
	public String toString(){
		return this.getNombre();
	}

	public void setCompras(List<Asiento> compras) {
		this.compras = compras;
	}

	public List<Asiento> getCompras() {
		return compras;
	}

}
