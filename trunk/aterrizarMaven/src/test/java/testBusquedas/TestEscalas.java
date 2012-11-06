package test.java.testBusquedas;

import java.util.ArrayList;
import main.java.aerolineas.Aerolineas;
import main.java.enumeraciones.Ciudad;
import main.java.vuelos.Vuelo;
import main.java.vuelos.VueloConEscala;

import org.junit.Assert;
import org.junit.Test;

public class TestEscalas {
	Aerolineas aerolinea = new Aerolineas();
	ArrayList<VueloConEscala> vuelosConEscala = new ArrayList<VueloConEscala>();
	ArrayList<Vuelo> vuelosSinEscala = new ArrayList<Vuelo>();
	
	@Test
	public void devuelveVuelosConEscalas(){
		vuelosConEscala = aerolinea.vuelosConEscala(Ciudad.BUENOS_AIRES, Ciudad.LOS_ANGELES);		
		Assert.assertNotNull(vuelosConEscala);
	}
	
}
