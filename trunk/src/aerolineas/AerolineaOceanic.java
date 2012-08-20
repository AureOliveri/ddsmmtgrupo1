package aerolineas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.oceanic.AsientoDTO;

import enumeraciones.DisponibilidadDeAsiento;

import usuarios.Usuario;
import vuelos.Asiento;
import vuelos.Vuelo;

public class AerolineaOceanic extends com.oceanic.AerolineaOceanic implements Aerolinea {

	private static final AerolineaOceanic INSTANCE = new AerolineaOceanic();
	private BigDecimal impuesto = new BigDecimal(0.0);
	private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
	
	public static AerolineaOceanic getInstance() {
		return INSTANCE;
	}
	
	public AerolineaOceanic() {
		
		List<AsientoDTO> asientosAerolinea = getAsientosDisponibles();
		ArrayList<String[]> asientosOceanic = new ArrayList<String[]>();
		for (AsientoDTO asientoDto : asientosAerolinea){
			asientosOceanic.add(transformarAsiento(asientoDto));	
		}
		
		
		for (String[] asientoO : asientosOceanic) {
			Asiento asiento = new Asiento(asientoO);
			String numeroDeVuelo = asiento.getNumeroDeVuelo();
			Vuelo vuelo = null;
			for(Vuelo vueloA : vuelos) {
				if(vueloA.getNumeroDeVuelo().equals(numeroDeVuelo)){
					vuelo = vueloA;
				}
			}
			if(vuelo == null) {
				vuelo = new Vuelo(asiento.getHoraLlegada(), asiento.getHoraSalida(), asiento.getOrigen(), 
						asiento.getDestino(), asiento.getFechaSalida(), asiento.getFechaLlegada(), numeroDeVuelo, this);
				vuelo.addAsiento(asiento);
				getVuelos().add(vuelo);				
			} else {
				vuelo.addAsiento(asiento);
			}
			asiento.setVuelo(vuelo);
		}
		
	}
	
	private String[] transformarAsiento(AsientoDTO asientoDTO) {
		String[] asientoF = new String[14];
		String codigoDeVuelo = asientoDTO.getCodigoDeVuelo() + "-" + asientoDTO.getNumeroDeAsiento().toString();
		asientoF[0] = codigoDeVuelo;
		asientoF[1] = asientoDTO.getPrecio().toString();
		asientoF[2] = asientoDTO.getClase().substring(0, 1);
		asientoF[3] = asientoDTO.getUbicacion().substring(0, 1);
		if(asientoDTO.getReservado()) {
			asientoF[4] = DisponibilidadDeAsiento.RESERVADO.getCodigo(); 
		} else {
			asientoF[4] = DisponibilidadDeAsiento.DISPONIBLE.getCodigo();
		}
		asientoF[5] = " ";
		asientoF[6] = asientoDTO.getHoraDeSalida();
		asientoF[7] = asientoDTO.getHoraDeLlegada();
		asientoF[8] = asientoDTO.getOrigen();
		asientoF[9] = asientoDTO.getDestino();
		asientoF[10] = asientoDTO.getFechaDeSalida();
		asientoF[11] = asientoDTO.getFechaDeLlegada();
		asientoF[12] = asientoDTO.getNumeroDeAsiento().toString();
		asientoF[13] = asientoDTO.getCodigoDeVuelo();
		return asientoF;
	}

	@Override
	public void comprar(Asiento unAsiento) {

	}

	@Override
	public String[][] busquedaDeAsientosDisponibles(String unOrigen,
			String unDestino, String unaFecha) {
//			return this.asientosDisponiblesParaOrigenYDestino(unOrigen, unDestino, unaFecha);
		return null;
	}

	public BigDecimal getImpuesto() {
		return impuesto;
	}
	
	public BigDecimal getPrecioFinal(Asiento unAsiento, Usuario unUsuario){
		BigDecimal precioFinal = new BigDecimal(0);
		precioFinal = precioFinal.add(unAsiento.getPrecio().multiply(getImpuesto()).add(unUsuario.getRecargo()));
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
		for(Vuelo vuelo : vuelos) {
			asientosAerolinea.addAll(vuelo.getAsientos());
		}
		return asientosAerolinea;
	}

}
