package busquedas;

import java.util.ArrayList;

import usuarios.Usuario;
import vuelos.Asiento;

public class BuscaPorUbicacion extends BuscadorDecorado {

	public BuscaPorUbicacion(BuscadorFinal buscador) {
		this.buscadorF = buscador;
	}
	
	
	@Override
	public ArrayList<Asiento> buscarAsientos(Busqueda busqueda, Usuario usuario) {  
		ArrayList<Asiento> asientosPorUbicacion = new ArrayList<Asiento>();
		ArrayList<Asiento> asientosDeBusqueda = this.buscadorF.buscarAsientos(busqueda, usuario);
		for (Asiento asiento : asientosDeBusqueda) {
			boolean ventana = asiento.getUbicacion().equals(busqueda.getVentana());
			boolean pasillo = asiento.getUbicacion().equals(busqueda.getPasillo());
			boolean centro = asiento.getUbicacion().equals(busqueda.getCentro());
			if (ventana || pasillo || centro) {
				asientosPorUbicacion.add(asiento);
			}
		}
		return asientosPorUbicacion;
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
