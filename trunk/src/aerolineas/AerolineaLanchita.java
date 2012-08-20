package aerolineas;

import java.math.BigDecimal;
import java.util.ArrayList;

import usuarios.Usuario;
import vuelos.Asiento;
import vuelos.Vuelo;

public class AerolineaLanchita extends com.lanchita.AerolineaLanchita implements Aerolinea {

	private static final AerolineaLanchita INSTANCE = new AerolineaLanchita();
	private BigDecimal impuesto = new BigDecimal(0.15);
	private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();

	
	public static AerolineaLanchita getInstance() {
		return INSTANCE;
	}
	
	
	public AerolineaLanchita() {
		
		String[][] asientosAerolinea = getAsientos();
		ArrayList<String[]> asientosLanchita = new ArrayList<String[]>();
		
		for (String[] asientoLanc : asientosAerolinea){
			asientosLanchita.add(transformarAsiento(asientoLanc));	
		}
		
		for (String[] asientoLanchita : asientosLanchita) {
			Asiento asiento = new Asiento(asientoLanchita);
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
	
	private String[] transformarAsiento(String[] asientoLanc) {
		String[] asientoF = new String[14];
		for(int i = 0; i<12; i++){
			asientoF[i] = asientoLanc[i];	
		}
		asientoF[12] = asientoLanc[0].substring(15, 16);
		asientoF[13] = asientoLanc[0].substring(0, 14);
		return asientoF;
	}


	@Override
	public void comprar(Asiento unAsiento) {

	}

	@Override
	public String[][] busquedaDeAsientosDisponibles(String unOrigen,
			String unDestino, String unaFecha) {
			return this.asientosDisponibles(unOrigen, unDestino, unaFecha, null, null, null);
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
