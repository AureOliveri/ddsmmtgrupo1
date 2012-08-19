package usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import enumeraciones.DisponibilidadDeAsiento;
import excepciones.asientoReservadoException;

import vuelos.Asiento;

import busquedas.Busqueda;

public class Usuario {

	private String dni;
	protected TipoUsuario tipoUsuario;
	protected BigDecimal recargo = new BigDecimal(20);
	private BigDecimal montoCompras = new BigDecimal(0);
	private ArrayList<Busqueda> historialBusquedas = new ArrayList<Busqueda>();

	public void comprarAsiento(Asiento unAsiento) {
		if (noTieneReserva(unAsiento)) {
			unAsiento.setDisponibilidad(DisponibilidadDeAsiento.RESERVADO);
		} else {
			throw new asientoReservadoException(("el asiento "
					+ unAsiento.getCodigoAsiento() + " se encuentra reservado"));
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
			ArrayList<Asiento> asientos, BigDecimal impuesto) {

		return this.tipoUsuario
				.getAsientosQueLeCorresponden(asientos, impuesto);

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
