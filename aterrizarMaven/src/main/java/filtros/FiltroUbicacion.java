package filtros;

import busquedas.Busqueda;
import usuarios.Usuario;
import vuelos.Asiento;

public class FiltroUbicacion implements Filtro {

	public boolean aplicarFiltro(Busqueda busqueda, Usuario usuario, Asiento asiento) { 
		if (busqueda.getOpcionales().getUbicaciones().isEmpty())
			return true;
		return busqueda.getOpcionales().getUbicaciones().contains(asiento.getUbicacion());
	}
}
