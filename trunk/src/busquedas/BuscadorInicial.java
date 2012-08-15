package busquedas;

import java.math.BigDecimal;
import java.util.ArrayList;

import usuarios.Usuario;
import vuelos.Asiento;
import busquedas.BuscadorFinal;

import com.lanchita.AerolineaLanchita;

import aerolineas.AerolineaLancha;


public class BuscadorInicial implements BuscadorFinal{

	private AerolineaLancha aerolineaLanchita = new AerolineaLancha();
	private BigDecimal impuesto = aerolineaLanchita.getImpuesto();
	protected CriterioBusqueda criterio;

	@Override
	public ArrayList<Asiento> buscarAsientos(Busqueda busqueda, Usuario usuario) {
		usuario.guardarBusqueda(busqueda);
		ArrayList<Asiento> asientos = new ArrayList<Asiento>();
		AerolineaLanchita aerolineaAux = AerolineaLanchita.getInstance();

		String[][] asientosDisponibles = aerolineaAux.asientosDisponibles(busqueda.getOrigen(), busqueda.getDestino(),
				busqueda.getFechaViaje(), null, null, null);
		int i;
		for (i = 0; i < asientosDisponibles.length; i++) {
			Asiento asiento = new Asiento(asientosDisponibles[i]);
			asientos.add(asiento);
		}
		
		return usuario.getAsientosQueLeCorreponden(asientos, this.impuesto);
		
	}

	public boolean noHayAsientosDisponibles(ArrayList<Asiento> asientos) {
		return asientos == null;
	}

	public ArrayList<ArrayList<String>> mostrarAsientosBusqueda(ArrayList<Asiento> asientos, Usuario usuario) {

		return this.getCriterio().mostrarAsientosBusqueda(asientos, usuario, impuesto);
		//		ArrayList<ArrayList<String>> asientosBusqueda = new ArrayList<ArrayList<String>>();
//		int i;
//		for (i = 0; i < asientos.size(); i++) {
//			ArrayList<String> valores = asientos.get(i).mostrarAsiento(asientos.get(i), this.impuesto, usuario.getTipoUsuario());
//			asientosBusqueda.add(valores);
//		}
//		return asientosBusqueda;
	}

	public BigDecimal getImpuesto() {
		return this.impuesto;
	}

	public void setCriterio(CriterioBusqueda criterio) {
		this.criterio = criterio;
	}

	public CriterioBusqueda getCriterio() {
		return criterio;
	}
}
