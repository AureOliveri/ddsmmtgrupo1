package busquedas;

import usuarios.Usuario;
import vuelos.Asiento;

public interface Filtro {
	
//	public ArrayList<Asiento> aplicarFiltro(Busqueda busqueda, Usuario usuario, ArrayList<Asiento> asientos);
	public boolean aplicarFiltro(Busqueda busqueda, Usuario usuario, Asiento asiento);

}
