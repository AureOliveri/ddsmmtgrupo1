package busquedas;

import java.math.BigDecimal;

import usuarios.Usuario;
import vuelos.Asiento;

public class FiltroSuperOferta implements Filtro {

	public boolean aplicarFiltro(Busqueda busqueda, Usuario usuario, Asiento asiento) { 
	
		BigDecimal impuesto = asiento.getVuelo().getAerolinea().getImpuesto();
		return asiento.esSuperOferta(impuesto, usuario.getTipoUsuario());
	}
}