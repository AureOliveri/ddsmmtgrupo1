package main.java.usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import main.java.enumeraciones.DisponibilidadDeAsiento;
import main.java.excepciones.AsientoReservadoException;

import main.java.vuelos.Asiento;

public abstract class TipoUsuario {

	protected abstract ArrayList<Asiento> getAsientosQueLeCorresponden(
			ArrayList<Asiento> asientos, TipoUsuario usuario);

	public abstract BigDecimal getRecargo();
	
	public abstract String getCodigo();

	public void comprarAsiento(Asiento unAsiento, String dni) {
		if (unAsiento.noEstaReservado()) {
			unAsiento.setDisponibilidad(DisponibilidadDeAsiento.RESERVADO);
		} else {
			throw new AsientoReservadoException(("el asiento "
					+ unAsiento.getCodigoAsiento() + " se encuentra reservado"));
		}

	}
	
	public void reservarAsiento(Asiento asientoReservado, Usuario usuario){		
	}
}
