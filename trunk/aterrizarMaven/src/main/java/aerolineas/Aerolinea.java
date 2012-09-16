package main.java.aerolineas;

import java.math.BigDecimal;
import java.util.ArrayList;

import main.java.busquedas.Busqueda;

import main.java.vuelos.Asiento;

public interface Aerolinea {

	public void comprar(Asiento unAsiento);
	
	public ArrayList<Asiento> asientosDisponibles(Busqueda busqueda);

	public BigDecimal getImpuesto();

}
