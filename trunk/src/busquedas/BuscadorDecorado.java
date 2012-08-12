package busquedas;

import java.math.BigDecimal;
import java.util.ArrayList;

import usuarios.Usuario;
import vuelos.Asiento;
import busquedas.BuscadorFinal;

public abstract class BuscadorDecorado implements BuscadorFinal {
	
	protected BuscadorFinal buscadorF;	
	abstract public ArrayList<Asiento> buscarAsientos(Busqueda busqueda, Usuario usuario);

	public BigDecimal getImpuesto() {
		return buscadorF.getImpuesto();
	}

	public ArrayList<ArrayList<String>> mostrarAsientosBusqueda(ArrayList<Asiento> asientos, Usuario usuario){
		return buscadorF.mostrarAsientosBusqueda(asientos, usuario);
	}
	
}
