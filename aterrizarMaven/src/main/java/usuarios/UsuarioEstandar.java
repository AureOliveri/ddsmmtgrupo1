package main.java.usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import main.java.fechas.Fecha;

import main.java.reservas.Reserva;
import main.java.vuelos.Asiento;



public class UsuarioEstandar extends TipoUsuario {

	@Override
	protected ArrayList<Asiento> getAsientosQueLeCorresponden(
			ArrayList<Asiento> asientos, TipoUsuario usuario) {
		ArrayList<Asiento> asientosNoVip = new ArrayList<Asiento>();
		for (Asiento asiento : asientos) {
			if (!asiento.esSuperOferta())
				asientosNoVip.add(asiento);
		}
		return asientosNoVip;

	}

	public BigDecimal getRecargo() {
		return new BigDecimal(0);
	}
	
	public String getCodigo() {
		return "estandar";
	}


	@Override
	public void reservarAsiento(Asiento asientoReservado, Usuario usuario){
		usuario.getReservas().add(asientoReservado);
		asientoReservado.reservar(usuario);
	}
	public Boolean puedeComprar(Asiento unAsiento, String dni){
		return unAsiento.noEstaReservado() || esTuReserva(unAsiento.getPrimeraReserva(), dni);
	}
	
	public Boolean esTuReserva(Reserva reserva, String dni){
		Fecha fechaAux  = new Fecha();
		if (fechaAux.esAnteriorQue(reserva.getFechaVencimiento())) {
			return reserva.getUsuario().getDni().equals(dni);
		} else {
			while(reserva.getFechaVencimiento().esMenorIgualQue(fechaAux)){
				reserva.getAsiento().getReservas().poll();
			}
			return reserva.getUsuario().getDni().equals(dni);
			
		}
	}

}
