package usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import enumeraciones.DisponibilidadDeAsiento;
import excepciones.asientoReservadoException;

import vuelos.Asiento;

public abstract class TipoUsuario {

	protected abstract ArrayList<Asiento> getAsientosQueLeCorresponden(
			ArrayList<Asiento> asientos);

	public abstract BigDecimal getRecargo();

	public void comprarAsiento(Asiento unAsiento, String dni) {
		if (unAsiento.noEstaReservado()) {
			unAsiento.setDisponibilidad(DisponibilidadDeAsiento.RESERVADO);
		} else {
			throw new asientoReservadoException(("el asiento "
					+ unAsiento.getCodigoAsiento() + " se encuentra reservado"));
		}

	}
}
