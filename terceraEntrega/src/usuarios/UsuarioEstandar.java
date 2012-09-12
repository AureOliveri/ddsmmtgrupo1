package usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import enumeraciones.DisponibilidadDeAsiento;
import excepciones.AsientoReservadoException;
import fechas.Fecha;

import vuelos.Asiento;
import vuelos.Reserva;



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
