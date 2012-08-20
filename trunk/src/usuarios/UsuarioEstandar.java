package usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import enumeraciones.DisponibilidadDeAsiento;
import excepciones.asientoReservadoException;

import vuelos.Asiento;
import vuelos.Reserva;



public class UsuarioEstandar extends TipoUsuario {

	@Override
	protected ArrayList<Asiento> getAsientosQueLeCorresponden(
			ArrayList<Asiento> asientos) {
		ArrayList<Asiento> asientosNoVip = new ArrayList<Asiento>();
		for (Asiento asiento : asientos) {
			BigDecimal impuesto = asiento.getVuelo().getAerolinea().getImpuesto();
			if (!asiento.esSuperOferta(impuesto, this))
				asientosNoVip.add(asiento);
		}
		return asientosNoVip;

	}

	@Override
	public BigDecimal getRecargo() {
		return new BigDecimal(0);
	}

	public void comprarAsiento(Asiento unAsiento, String dni) {
		if(puedeComprar(unAsiento, dni)){
			unAsiento.setDisponibilidad(DisponibilidadDeAsiento.RESERVADO);
		} else {
			throw new asientoReservadoException(("el asiento "
					+ unAsiento.getCodigoAsiento() + " se encuentra reservado"));
		}
		
	}
	
	public Boolean puedeComprar(Asiento unAsiento, String dni){
		return (unAsiento.noEstaReservado() || esTuReserva(unAsiento.getPrimeraReserva(), dni));
	}
	
	public Boolean esTuReserva(Reserva reserva, String dni){
		return reserva.getDni().equals(dni);
	}

}
