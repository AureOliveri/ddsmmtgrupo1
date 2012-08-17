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
		int filtro = 0;
		for (Asiento asiento : asientosDeBusqueda) {
			boolean claseP = asiento.getClaseDeAsiento().equals(busqueda.getOpcionales().getPrimera());
			boolean claseE = asiento.getClaseDeAsiento().equals(busqueda.getOpcionales().getEjecutiva());
			boolean claseT = asiento.getClaseDeAsiento().equals(busqueda.getOpcionales().getTurista());
			if (claseP || claseE || claseT) {
				asientosPorClase.add(asiento);
				filtro++;
			}
		}
		if (filtro == 0) return asientosDeBusqueda;
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
