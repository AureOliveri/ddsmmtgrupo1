package busquedas;

import java.util.ArrayList;

import usuarios.Usuario;
import vuelos.Asiento;

public class BuscaPorSuperOferta extends BuscadorDecorado {

	public BuscaPorSuperOferta(BuscadorFinal buscador) {
		this.buscadorF = buscador;
	}
	
	
	@Override
	public ArrayList<Asiento> buscarAsientos(Busqueda busqueda, Usuario usuario) {  
		ArrayList<Asiento> asientosSuper = new ArrayList<Asiento>();
		ArrayList<Asiento> asientosDeBusqueda = this.buscadorF.buscarAsientos(busqueda, usuario);
		for (Asiento asiento : asientosDeBusqueda) {
			if (asiento.esSuperOferta(super.getImpuesto(), usuario.getTipoUsuario())) {
				asientosSuper.add(asiento);
			}
		}
		return asientosSuper;

	}
	
	

}
