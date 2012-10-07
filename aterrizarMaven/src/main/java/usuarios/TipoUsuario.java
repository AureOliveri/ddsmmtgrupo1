package main.java.usuarios;

import java.math.BigDecimal;
import java.util.ArrayList;

import main.java.excepciones.ReservaNoEstandarException;

import main.java.vuelos.Asiento;

public abstract class TipoUsuario {

	protected abstract ArrayList<Asiento> getAsientosQueLeCorresponden(
			ArrayList<Asiento> asientos, TipoUsuario usuario);

	public abstract BigDecimal getRecargo();
	
	public abstract String getCodigo();

	public void reservarAsiento(Asiento asientoReservado, Usuario usuario){		
		throw new ReservaNoEstandarException();
	}
}
