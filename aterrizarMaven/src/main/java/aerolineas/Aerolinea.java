package aerolineas;

import java.math.BigDecimal;
import java.util.ArrayList;

import busquedas.Busqueda;

import vuelos.Asiento;

public interface Aerolinea {

	public void comprar(Asiento unAsiento);
	
	public ArrayList<Asiento> asientosDisponibles(Busqueda busqueda);

	public BigDecimal getImpuesto();

}
