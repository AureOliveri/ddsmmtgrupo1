package busquedas;

import java.math.BigDecimal;
import java.util.ArrayList;

import usuarios.Usuario;
import vuelos.Asiento;

public class BuscaPorPrecio extends BuscadorDecorado {

	public BuscaPorPrecio(BuscadorFinal buscador) {
		this.buscadorF = buscador;
	}
	
	
	@Override
	public ArrayList<Asiento> buscarAsientos(Busqueda busqueda, Usuario usuario) {  
		ArrayList<Asiento> asientosPorPrecio = new ArrayList<Asiento>();
		ArrayList<Asiento> asientosDeBusqueda = this.buscadorF.buscarAsientos(busqueda, usuario);
		for (Asiento asiento : asientosDeBusqueda) {
			BigDecimal precioTotal = asiento.precioTotal(super.getImpuesto(), usuario.getTipoUsuario());
			boolean precioMin = precioTotal.compareTo(busqueda.getPrecioMin()) >= 0;
			boolean precioMax = precioTotal.compareTo(busqueda.getPrecioMax()) <= 0;
			
			if (precioMin && precioMax) {
				asientosPorPrecio.add(asiento);
			}
		}
		return asientosPorPrecio;

	}


	@Override
	public void setCriterio(CriterioBusqueda precioDes) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public CriterioBusqueda getCriterio() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
