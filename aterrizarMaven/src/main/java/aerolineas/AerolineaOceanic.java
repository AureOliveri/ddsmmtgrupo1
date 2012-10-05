package main.java.aerolineas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import main.java.busquedas.Busqueda;

import com.oceanic.AsientoDTO;

import main.java.enumeraciones.DisponibilidadDeAsiento;

import main.java.usuarios.Usuario;
import main.java.vuelos.Asiento;
import main.java.vuelos.Vuelo;

public class AerolineaOceanic extends com.oceanic.AerolineaOceanic implements
		Aerolinea {

	private static final AerolineaOceanic INSTANCE = new AerolineaOceanic();
	private String nombre;
	private BigDecimal impuesto = new BigDecimal(0.0);
	private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();

	public static AerolineaOceanic getInstance() {
		return INSTANCE;
	}

	public AerolineaOceanic() {

		setNombre("Oceanic");
		List<AsientoDTO> asientosAerolinea = getAsientosDisponibles();

		for (AsientoDTO asiento : asientosAerolinea) {
			String numeroDeVuelo = asiento.getCodigoDeVuelo();
			Vuelo vuelo = null;
			for (Vuelo vueloA : vuelos) {
				if (vueloA.getNumeroDeVuelo().equals(numeroDeVuelo)) {
					vuelo = vueloA;
				}
			}
			if (vuelo == null) {
				vuelo = new Vuelo(asiento.getHoraDeLlegada(),
						asiento.getHoraDeSalida(), asiento.getOrigen(),
						asiento.getDestino(), asiento.getFechaDeSalida(),
						asiento.getFechaDeLlegada(), numeroDeVuelo, this);
				getVuelos().add(vuelo);
			}

			String codigoAsiento = obtenerCodigoAsiento(asiento
					.getNumeroDeAsiento().toString(),
					asiento.getCodigoDeVuelo());
			String disponibilidad = obtenerDisponibilidad(asiento
					.getReservado());
			String clase = obtenerClaseAsiento(asiento);
			String ubicacion = obtenerUbicacionAsiento(asiento);
			Asiento asientoReal = new Asiento(codigoAsiento, asiento
					.getPrecio().toString(), clase, ubicacion, disponibilidad,
					" ", asiento.getNumeroDeAsiento().toString(),
					asiento.getCodigoDeVuelo(), vuelo);
			vuelo.addAsiento(asientoReal);
		}

	}

	private String obtenerCodigoAsiento(String numeroDeAsiento,
			String numeroDeVuelo) {
		String codigoDeVuelo = numeroDeVuelo + "-" + numeroDeAsiento;
		return codigoDeVuelo;
	}

	private String obtenerDisponibilidad(Boolean reservado) {
		String disp;
		if (reservado) {
			disp = DisponibilidadDeAsiento.RESERVADO.getCodigo();
			return disp;
		}
		return disp = DisponibilidadDeAsiento.DISPONIBLE.getCodigo();

	}

	private String obtenerClaseAsiento(AsientoDTO asiento) {
		String cl = asiento.getClase().substring(0, 1);
		return cl;
	}

	private String obtenerUbicacionAsiento(AsientoDTO asiento) {
		String ub = asiento.getUbicacion().substring(0, 1);
		return ub;
	}

	@Override
	public void comprar(Asiento unAsiento, Usuario usuario) {
		Integer numeroAsiento = Integer.parseInt(unAsiento.getNumeroDeAsiento());
		String codigoVuelo = unAsiento.getVuelo().getNumeroDeVuelo();
		comprarSiHayDisponibilidad(usuario.getDni(), codigoVuelo, numeroAsiento);
		usuario.getCompras().add(unAsiento);
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

	public Asiento retornarAsiento(AsientoDTO asientoDto) {
		ArrayList<Asiento> asientosAerolinea = new ArrayList<Asiento>();
		asientosAerolinea = getAsientosAerolinea();
		for (Asiento asientoC : asientosAerolinea) {
			if (asientoC.getNumeroDeVuelo().equals(
					asientoDto.getCodigoDeVuelo())
					&& (asientoC.getNumeroDeAsiento().equals(asientoDto
							.getNumeroDeAsiento().toString()))) {
				return asientoC;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Asiento> asientosDisponibles(Busqueda busqueda) {
		ArrayList<Asiento> asientos = new ArrayList<Asiento>();
		Asiento asiento = new Asiento();
		String fecha = busqueda.getFechaV() != null ? busqueda.getFechaV()
				.getFechaS() : null;

		List<AsientoDTO> asientosDisponibles = this.getAsientosDisponibles(
				busqueda.getOrigen().getCodigo(), busqueda.getDestino().getCodigo(), fecha);

		for (AsientoDTO asientoDto : asientosDisponibles) {
			asiento = retornarAsiento(asientoDto);
			asientos.add(asiento);
		}
		return asientos;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<AsientoDTO> getAsientosDisponibles(String origen,
			String destino, String fecha) {
		try {
			if (origen == null && destino == null) {
				return getAsientosDisponibles();
			} else {
				if (destino == null) {
					return asientosDisponiblesParaOrigen(origen, fecha);
				} else {
					return asientosDisponiblesParaOrigenYDestino(origen, destino,
							fecha);
				}
			}
		} catch (NullPointerException ex) {
			// Oceanic no conoce el destino
			return new ArrayList();
		}
	}

	@Override
	public void reservar(Asiento asiento, Usuario usuario) {
		AerolineaOceanic.getInstance().reservar(usuario.getDni(),
				asiento.getNumeroDeVuelo(),
				Integer.parseInt(asiento.getNumeroDeAsiento()));
		usuario.getReservas().add(asiento);
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String getNombre() {
		return this.nombre;
	}

}
