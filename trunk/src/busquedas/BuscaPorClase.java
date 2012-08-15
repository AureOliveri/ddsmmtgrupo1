package busquedas;

import java.util.ArrayList;

import usuarios.Usuario;
import vuelos.Asiento;

public class BuscaPorClase extends BuscadorDecorado {

	public BuscaPorClase(BuscadorFinal buscador) {
		this.buscadorF = buscador;
	}
	
	
	@Override
	public ArrayList<Asiento> buscarAsientos(Busqueda busqueda, Usuario usuario) {  
		ArrayList<Asiento> asientosPorClase = new ArrayList<Asiento>();
		ArrayList<Asiento> asientosDeBusqueda = this.buscadorF.buscarAsientos(busqueda, usuario);
		for (Asiento asiento : asientosDeBusqueda) {
			boolean claseP = asiento.getClaseDeAsiento().equals(busqueda.getClaseP());
			boolean claseE = asiento.getClaseDeAsiento().equals(busqueda.getClaseT());
			boolean claseT = asiento.getClaseDeAsiento().equals(busqueda.getClaseE());
			if (claseP || claseE || claseT) {
				asientosPorClase.add(asiento);
			}
		}
		return asientosPorClase;

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
