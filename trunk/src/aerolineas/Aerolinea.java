package aerolineas;

import vuelos.Asiento;

public interface Aerolinea {

	public void comprar(Asiento unAsiento);

	public  String[][] busquedaDeAsientosDisponibles(String unOrigen,
			String unDestino, String unaFechaDeSalida, String unaFechaDeLlegada);

}
