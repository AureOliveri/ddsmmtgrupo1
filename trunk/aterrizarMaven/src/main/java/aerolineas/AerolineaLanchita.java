package main.java.aerolineas;

import java.math.BigDecimal;
import java.util.ArrayList;

import main.java.busquedas.Busqueda;

import main.java.fechas.Fecha;

import main.java.usuarios.Usuario;
import main.java.vuelos.Asiento;
import main.java.vuelos.Vuelo;

public class AerolineaLanchita extends com.lanchita.AerolineaLanchita implements
		Aerolinea {

	private static final AerolineaLanchita INSTANCE = new AerolineaLanchita();
	private BigDecimal impuesto = new BigDecimal(0.15);
	private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();

	public static AerolineaLanchita getInstance() {
		return INSTANCE;
	}

	public AerolineaLanchita() {

		String[][] asientosAerolinea = getAsientos();

		for (String[] asientoLanchita : asientosAerolinea) {
			String numeroDeVuelo = obtenerNumeroDeVuelo(asientoLanchita[0]);
			Vuelo vuelo = null;
			for (Vuelo vueloA : vuelos) {
				if (vueloA.getNumeroDeVuelo().equals(numeroDeVuelo)) {
					vuelo = vueloA;
				}
			}
			if (vuelo == null) {

				vuelo = new Vuelo(asientoLanchita[7], asientoLanchita[6],
						asientoLanchita[8], asientoLanchita[9],
						asientoLanchita[10], asientoLanchita[11],
						numeroDeVuelo, this);
				getVuelos().add(vuelo);
			}

			Asiento asientoReal = new Asiento(asientoLanchita[0],
					asientoLanchita[1], asientoLanchita[2], asientoLanchita[3],
					asientoLanchita[4], asientoLanchita[5],
					obtenerNumeroAsiento(asientoLanchita[0]),
					obtenerNumeroDeVuelo(asientoLanchita[0]), vuelo);
			vuelo.addAsiento(asientoReal);
		}

	}

	private String obtenerNumeroDeVuelo(String codigoAsiento) {
		String nVuelo = codigoAsiento.substring(0, 14);
		return nVuelo;
	}

	private String obtenerNumeroAsiento(String codigoAsiento) {
		String nAsiento = codigoAsiento.substring(15, 16);
		return nAsiento;
	}

	@Override
	public void comprar(Asiento unAsiento) {

	}

	public BigDecimal getImpuesto() {
		return impuesto;
	}

	public BigDecimal getPrecioFinal(Asiento unAsiento, Usuario unUsuario) {
		BigDecimal precioFinal = new BigDecimal(0);
		precioFinal = precioFinal.add(unAsiento.getPrecioInicial()
				.multiply(getImpuesto()).add(unUsuario.getRecargo()));
		return precioFinal;
	}

	public void setVuelos(ArrayList<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public ArrayList<Vuelo> getVuelos() {
		return vuelos;
	}

	public ArrayList<Asiento> getAsientosAerolinea() {
		ArrayList<Asiento> asientosAerolinea = new ArrayList<Asiento>();
		for (Vuelo vuelo : vuelos) {
			asientosAerolinea.addAll(vuelo.getAsientos());
		}
		return asientosAerolinea;
	}

	public Asiento retornarAsiento(String[] asientoD, String origen,
			String destino, Fecha fecha) {
		ArrayList<Asiento> asientosAerolinea = new ArrayList<Asiento>();
		asientosAerolinea = getAsientosAerolinea();
		for (Asiento asientoC : asientosAerolinea) {
			boolean cumpleOrigen = asientoC.getOrigen().equals(origen);
			boolean cumpleDestino = asientoC.getDestino().equals(destino);
			boolean cumpleFechaS = asientoC.getFechaSalida().esMenorIgualQue(
					fecha);
			boolean cumpleFechaD = asientoC.getFechaLlegada().esMayorIgualQue(
					fecha);
			boolean cumpleNumVuelo = asientoC.getCodigoAsiento().equals(
					asientoD[0]);
			if (cumpleOrigen && cumpleDestino && cumpleFechaS && cumpleFechaD
					&& cumpleNumVuelo) {
				return asientoC;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Asiento> asientosDisponibles(Busqueda busqueda) {
		String[][] asientosDisponibles;
		ArrayList<Asiento> asientos = new ArrayList<Asiento>();
		Asiento asiento = new Asiento();
		asientosDisponibles = asientosDisponibles(busqueda.getOrigen(),
				busqueda.getDestino(), busqueda.getFechaV().getFechaS(), null,
				null, null);
		for (String[] asientoD : asientosDisponibles) {
			asiento = retornarAsiento(asientoD, busqueda.getOrigen(),
					busqueda.getDestino(), busqueda.getFechaV());
			if (asiento != null) {
				asientos.add(asiento);
			}
		}
		return asientos;
	}

	@Override
	public void reservar(Asiento asiento, Usuario usuario) {
		AerolineaLanchita.getInstance().reservar(asiento.getCodigoAsiento(),
				usuario.getDni());
	}

}
