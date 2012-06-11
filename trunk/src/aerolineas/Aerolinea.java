package aerolineas;

import java.util.ArrayList;

import Vuelos.Asiento;

public interface Aerolinea {

	public void comprar(Asiento unAsiento);

	public  ArrayList<Asiento> busquedaDeAsientosDisponibles(String unOrigen,
			String unDestino, String unaFechaDeSalida, String unaFechaDeLlegada);

}
