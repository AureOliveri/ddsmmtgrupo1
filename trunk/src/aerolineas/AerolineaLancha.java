package aerolineas;

import java.math.BigDecimal;
import java.util.ArrayList;

import Busquedas.Busqueda;
import Vuelos.Asiento;
import com.lanchita.AerolineaLanchita;

public class AerolineaLancha implements Aerolinea {

	private BigDecimal impuesto;
	AerolineaLanchita aerolinea = AerolineaLanchita.getInstance();
	
	@Override
	public void comprar(Asiento unAsiento) {

	}

	@Override
	public ArrayList<Busqueda> busquedaDeAsientosDisponibles(String unOrigen,
			String unDestino, String unaFechaDeSalida, String unaFechaDeLlegada) {
	
		aerolinea.asientosDisponibles(unOrigen, unDestino, unaFechaDeSalida, null, unaFechaDeLlegada, null);
		return null;
		
	}

	public void setImpuesto(BigDecimal impuesto) {
		this.impuesto = impuesto;
	}

	public BigDecimal getImpuesto() {
		return impuesto;
	}

}
