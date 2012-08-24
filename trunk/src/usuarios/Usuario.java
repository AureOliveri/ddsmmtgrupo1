package usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import excepciones.asientoReservadoException;

import vuelos.Asiento;

import busquedas.Busqueda;

public class Usuario {

	private String dni;
	protected TipoUsuario tipoUsuario;
	protected BigDecimal recargo = new BigDecimal(20);
	private BigDecimal montoCompras = new BigDecimal(0);
	private ArrayList<Busqueda> historialBusquedas = new ArrayList<Busqueda>();
	private ArrayList<Asiento> reservas = new ArrayList<Asiento>();

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
		} catch (asientoReservadoException e) {

		}
	}

	public Boolean noTieneReserva(Asiento unAsiento) {
		return (unAsiento.getReservado().equals(false));
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
			ArrayList<Asiento> asientos) {

		return this.tipoUsuario.getAsientosQueLeCorresponden(asientos);

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
}
