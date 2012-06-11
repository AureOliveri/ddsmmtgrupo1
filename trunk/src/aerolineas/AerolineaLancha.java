package aerolineas;

import java.math.BigDecimal;

import Vuelos.Asiento;
import com.lanchita.AerolineaLanchita;

public class AerolineaLancha implements Aerolinea {

	private BigDecimal impuesto = new BigDecimal(0.15);
	private AerolineaLanchita aerolinea = AerolineaLanchita.getInstance();
	
	@Override
	public void comprar(Asiento unAsiento) {

	}

	@Override
	public String[][] busquedaDeAsientosDisponibles(String unOrigen,
			String unDestino, String unaFechaDeSalida, String unaFechaDeLlegada) {
	
		String[][] asientosDisp = aerolinea.asientosDisponibles(unOrigen, unDestino, unaFechaDeSalida, null, 
				unaFechaDeLlegada, null);
		
		return asientosDisp;
	}

	public BigDecimal getImpuesto() {
		return impuesto;
	}

}
