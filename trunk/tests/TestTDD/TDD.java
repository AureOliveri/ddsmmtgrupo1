package TestTDD;

import junit.framework.Assert;

import org.junit.Test;

import Usuarios.*;
import Vuelos.Asiento;
import Vuelos.Vuelo;

public class TDD {
	@Test
	public void unUsuarioVIPCompraUnoDeLosVuelos(){
		UsuarioVIP unUsuario = new UsuarioVIP();
		Vuelo unVuelo = new Vuelo();
		Asiento unAsiento = new Asiento();
		unAsiento.setDisponibilidad("D");
		unUsuario.compraAsiento(unAsiento, unVuelo);
		Assert.assertFalse(unVuelo.yaNoEstasDisponible(unAsiento));
		
	}
	@Test
	public void unUsuarioEstandarCompraUnoDeLosVuelos(){
		UsuarioEstandar unUsuario = new UsuarioEstandar();
		Vuelo unVuelo = new Vuelo();
		Asiento unAsiento = new Asiento();
		unAsiento.setDisponibilidad("D");
		unUsuario.compraAsiento(unAsiento, unVuelo);
		Assert.assertFalse(unVuelo.yaNoEstasDisponible(unAsiento));
	}
	@Test
	public void unUsuarioNoRegistradoCompraUnoDeLosVuelos(){
		UsuarioNoRegistrado unUsuario = new UsuarioNoRegistrado();
		Vuelo unVuelo = new Vuelo();
		Asiento unAsiento = new Asiento();
		unAsiento.setDisponibilidad("D");
		unUsuario.compraAsiento(unAsiento, unVuelo);
		Assert.assertFalse(unVuelo.yaNoEstasDisponible(unAsiento));
	}


}

