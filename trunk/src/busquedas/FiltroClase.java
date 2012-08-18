package busquedas;

import usuarios.Usuario;
import vuelos.Asiento;

public class FiltroClase implements Filtro {

	public boolean aplicarFiltro(Busqueda busqueda, Usuario usuario, Asiento asiento) { 
		if (busqueda.getOpcionales().getClases().isEmpty())
			return true;
		return busqueda.getOpcionales().getClases().contains(asiento.getClaseDeAsiento());
	}
}
