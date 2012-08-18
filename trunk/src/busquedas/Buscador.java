package busquedas;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.ArrayList;

import usuarios.Usuario;
import vuelos.Asiento;

import aerolineas.AerolineaLanchita;

public class Buscador{

	private AerolineaLanchita aerolineaLanchita = new AerolineaLanchita();
	private BigDecimal impuesto = aerolineaLanchita.getImpuesto();
	protected CriterioBusqueda criterio;
	private ArrayList<Filtro> filtros = new ArrayList<Filtro>();

	public ArrayList<Asiento> buscarAsientos(Busqueda busqueda, Usuario usuario) {
		usuario.guardarBusqueda(busqueda);
		ArrayList<Asiento> asientos = new ArrayList<Asiento>();
		asientos = aerolineaLanchita.getAsientosAerolinea();

		ArrayList<Asiento> asientosDeBusqueda = new ArrayList<Asiento>();

		if (getFiltros().isEmpty()) {
			return usuario.getAsientosQueLeCorreponden(asientos, this.impuesto);
		} else {
			for(Asiento asiento : asientos) {
				boolean cumple = true;
				Filtro filtro = null;
				for (Iterator<Filtro> itFiltros = filtros.iterator(); itFiltros.hasNext() && cumple; ) {
					filtro = itFiltros.next();
					cumple = filtro.aplicarFiltro(busqueda, usuario, asiento);
				}
				if(cumple) {
					asientosDeBusqueda.add(asiento);
				}
			}
			return usuario.getAsientosQueLeCorreponden(asientosDeBusqueda, this.impuesto);
		}
	}

	public boolean noHayAsientosDisponibles(ArrayList<Asiento> asientos) {
		return asientos == null;
	}

	public ArrayList<ArrayList<String>> mostrarAsientosBusqueda(ArrayList<Asiento> asientos, Usuario usuario) {
		return this.getCriterio().mostrarAsientosBusqueda(asientos, usuario, impuesto);
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
	
	public void setFiltros(ArrayList<Filtro> filtros) {
		this.filtros = filtros;
	}
	
	public ArrayList<Filtro> getFiltros() {
		return filtros;
	}
}
