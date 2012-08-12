package busquedas;

import java.math.BigDecimal;
import java.util.ArrayList;

import aerolineas.AerolineaLancha;

import usuarios.Usuario;
import vuelos.Asiento;


public interface BuscadorFinal {
	
//	public AerolineaLancha aerolineaLanchita = new AerolineaLancha();
//	public BigDecimal impuesto = aerolineaLanchita.getImpuesto();	
	
	public ArrayList<Asiento> buscarAsientos(Busqueda busqueda, Usuario usuario);
	public BigDecimal getImpuesto();
	public ArrayList<ArrayList<String>> mostrarAsientosBusqueda(
			ArrayList<Asiento> asientos, Usuario usuario);
}
