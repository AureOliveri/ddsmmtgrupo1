package busquedas;

import java.math.BigDecimal;
import java.util.ArrayList;


import usuarios.Usuario;
import vuelos.Asiento;


public interface BuscadorFinal {
	
	public ArrayList<Asiento> buscarAsientos(Busqueda busqueda, Usuario usuario);

	public BigDecimal getImpuesto();
	
	public ArrayList<ArrayList<String>> mostrarAsientosBusqueda(ArrayList<Asiento> asientos, Usuario usuario);
}
