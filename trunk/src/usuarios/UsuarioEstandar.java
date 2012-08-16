package usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import excepciones.asientoReservadoException;

import vuelos.Asiento;
import vuelos.Reserva;



public class UsuarioEstandar extends TipoUsuario {

	@Override
	protected ArrayList<Asiento> getAsientosQueLeCorresponden(
			ArrayList<Asiento> asientos, BigDecimal impuesto) {
		ArrayList<Asiento> asientosNoVip = new ArrayList<Asiento>();
		for (Asiento asiento : asientos) {

			if (!asiento.esSuperOferta(impuesto, this))
				asientosNoVip.add(asiento);
		}
		return asientosNoVip;

	}

	@Override
	public BigDecimal getRecargo() {
		return new BigDecimal(0);
	}

	public void comprarAsiento(Asiento unAsiento) {
		if(puedeComprar(unAsiento)){
			unAsiento.setDisponibilidad("R");
		} else {
			throw new asientoReservadoException(("el asiento "
					+ unAsiento.getCodigoAsiento() + " se encuentra reservado"));
		}
		
	}
	
	public Boolean puedeComprar(Asiento unAsiento){
		return (unAsiento.noEstaReservado() || esTuReserva(unAsiento.getPrimeraReserva()));
	}
	
	public Boolean esTuReserva(Reserva reserva){
		return reserva.getDni().equals(this.getDni());
	}

}
