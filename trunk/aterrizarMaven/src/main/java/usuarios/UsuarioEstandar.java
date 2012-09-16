package main.java.usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import main.java.enumeraciones.DisponibilidadDeAsiento;
import main.java.excepciones.AsientoReservadoException;
import main.java.fechas.Fecha;

import main.java.vuelos.Asiento;
import main.java.vuelos.Reserva;



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

	public void comprarAsiento(Asiento unAsiento, String dni) {
		if(puedeComprar(unAsiento, dni)){
			unAsiento.setDisponibilidad(DisponibilidadDeAsiento.RESERVADO);
		} else {
			throw new AsientoReservadoException(("el asiento "
					+ unAsiento.getCodigoAsiento() + " se encuentra reservado"));
		}
		
	}
	@Override
	public void reservarAsiento(Asiento asientoReservado, Usuario usuario){
		usuario.getReservas().add(asientoReservado);
		asientoReservado.reservar(usuario.getDni());
	}
	public Boolean puedeComprar(Asiento unAsiento, String dni){
		return unAsiento.noEstaReservado() || esTuReserva(unAsiento.getPrimeraReserva(), dni);
	}
	
	public Boolean esTuReserva(Reserva reserva, String dni){
		Fecha fechaAux  = new Fecha();
		if (fechaAux.esAnteriorQue(reserva.getFechaVencimiento())) {
			return reserva.getDni().equals(dni);
		} else {
			while(reserva.getFechaVencimiento().esMenorIgualQue(fechaAux)){
				reserva.getAsiento().getReservas().poll();
			}
			return reserva.getDni().equals(dni);
			
		}
	}

}
