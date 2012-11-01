package test.java.testBusquedas;

import java.util.ArrayList;
import main.java.aerolineas.Aerolineas;
import main.java.enumeraciones.Ciudad;
import main.java.vuelos.Vuelo;
import org.junit.Assert;
import org.junit.Test;

public class TestEscalas {
	Aerolineas aerolinea = new Aerolineas();
	ArrayList<Vuelo> vuelosConEscala = new ArrayList<Vuelo>();
	ArrayList<Vuelo> vuelosSinEscala = new ArrayList<Vuelo>();
	
	@Test
	public void devuelveVuelosConEscalas(){
		vuelosConEscala = aerolinea.vuelosConEscala(Ciudad.BUENOS_AIRES, Ciudad.LOS_ANGELES);		
		Assert.assertNotNull(vuelosConEscala);
	}
	
}
