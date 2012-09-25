package main.java.aerolineas;

import java.math.BigDecimal;
import java.util.ArrayList;

import main.java.busquedas.Busqueda;

import main.java.usuarios.Usuario;
import main.java.vuelos.Asiento;

public interface Aerolinea {

	public void comprar(Asiento unAsiento);
	
	public ArrayList<Asiento> asientosDisponibles(Busqueda busqueda);

	public BigDecimal getImpuesto();
	
	public void reservar(Asiento asiento, Usuario usuario);

	public String getNombre();
	
}
