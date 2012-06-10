package aerolineas;

import Vuelos.Asiento;
import com.lanchita.AerolineaLanchita;

public class AerolineaLancha implements Aerolinea {

	AerolineaLanchita aerolinea = AerolineaLanchita.getInstance();
	@Override
	public void comprar(Asiento unAsiento) {


	}

	@Override
	public void busquedaDeAsientosDisponibles(String unOrigen,
			String unDestino, String unaFechaDeSalida, String unaFechaDeLlegada) {
	
		aerolinea.asientosDisponibles(unOrigen, unDestino, unaFechaDeSalida, null, unaFechaDeLlegada, null);
		
	}

}
