package aerolineas;

import java.util.ArrayList;

import Busquedas.Busqueda;
import Vuelos.Asiento;

public interface Aerolinea {

	public void comprar(Asiento unAsiento);

	public  ArrayList<Busqueda> busquedaDeAsientosDisponibles(String unOrigen,
			String unDestino, String unaFechaDeSalida, String unaFechaDeLlegada);
}
