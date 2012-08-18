package aerolineas;

import java.math.BigDecimal;

import vuelos.Asiento;

public interface Aerolinea {

	public void comprar(Asiento unAsiento);

	public  String[][] busquedaDeAsientosDisponibles(String unOrigen,
			String unDestino, String unaFecha);

	public BigDecimal getImpuesto();

}
