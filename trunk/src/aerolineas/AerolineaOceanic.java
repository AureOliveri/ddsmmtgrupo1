package aerolineas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.oceanic.AsientoDTO;

import usuarios.Usuario;
import vuelos.Asiento;
import vuelos.Vuelo;

public class AerolineaOceanic extends com.oceanic.AerolineaOceanic implements Aerolinea {

	private BigDecimal impuesto = new BigDecimal(0.15);
	private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
	
	public AerolineaOceanic() {
		
		List<AsientoDTO> asientosAerolinea = getAsientosDisponibles();
		ArrayList<String[]> asientosOceanic = new ArrayList<String[]>();
		
		asientosOceanic = transformarAsiento(asientosAerolinea);
		
//		int j = 0;
//		AsientoDTO asientoDto = null;
//		for (Iterator<AsientoDTO> itAsientoDto = asientosAerolinea.iterator(); itAsientoDto.hasNext() && j < asientosAerolinea.size(); j++) {
//			asientoDto = itAsientoDto.next();
//			String[] asiento = transformarAsiento(itAsientoDto);
//			asientosOceanic[j] = asiento;
//		}
						
		for (int i = 0; i < asientosAerolinea.size(); i++) {
			Asiento asiento = new Asiento(asientosOceanic[i]);
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
			}			
			asiento.setVuelo(vuelo);
		}
		
	}
	
	private ArrayList<String> transformarAsiento(List<AsientoDTO> asientosAerolinea) {
		ArrayList<String> asientos = new ArrayList<String>();
		String[][] asientosF;
		for(AsientoDTO asiento : asientosAerolinea) {
			asientos.add(asiento != null ? asiento.toString() : null);
		}
		
		return null;
	}



	@Override
	public void comprar(Asiento unAsiento) {

	}

	@Override
	public String[][] busquedaDeAsientosDisponibles(String unOrigen,
			String unDestino, String unaFecha) {
			return this.asientosDisponiblesParaOrigenYDestino(unOrigen, unDestino, unaFecha);
//	}

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
