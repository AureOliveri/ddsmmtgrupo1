package aerolineas;

import Vuelos.Asiento;

public interface Aerolinea {

	public void comprar(Asiento unAsiento);

	public  void busquedaDeAsientosDisponibles(String unOrigen,
			String unDestino, String unaFechaDeSalida, String unaFechaDeLlegada);
}
