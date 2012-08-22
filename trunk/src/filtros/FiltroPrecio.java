package filtros;

import java.math.BigDecimal;

import busquedas.Busqueda;

import usuarios.Usuario;
import vuelos.Asiento;

public class FiltroPrecio implements Filtro {

	public boolean aplicarFiltro(Busqueda busqueda, Usuario usuario, Asiento asiento) { 
		boolean cumplePrecioMin = true;
		boolean cumplePrecioMax = true;
		BigDecimal impuesto = asiento.getVuelo().getAerolinea().getImpuesto();
		if (busqueda.getOpcionales().getPrecioMin() == null) {
			cumplePrecioMin = true;
		} else {
			cumplePrecioMin = asiento.precioTotal(impuesto, usuario.getTipoUsuario()).compareTo(busqueda.getOpcionales().getPrecioMin()) >= 0;
		}
		if (busqueda.getOpcionales().getPrecioMax() == null) {
			cumplePrecioMax = true;
		} else {
			cumplePrecioMax = asiento.precioTotal(impuesto, usuario.getTipoUsuario()).compareTo(busqueda.getOpcionales().getPrecioMax()) <= 0;
		}
		return cumplePrecioMin && cumplePrecioMax;
	}
}
