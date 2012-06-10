package TestTDD;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import Busquedas.Busqueda;
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
		Assert.assertTrue(unVuelo.yaNoEstasDisponible(unAsiento));
		
	}
	@Test
	public void unUsuarioEstandarCompraUnoDeLosVuelos(){
		UsuarioEstandar unUsuario = new UsuarioEstandar();
		Vuelo unVuelo = new Vuelo();
		Asiento unAsiento = new Asiento();
		unAsiento.setDisponibilidad("D");
		unUsuario.compraAsiento(unAsiento, unVuelo);
		Assert.assertTrue(unVuelo.yaNoEstasDisponible(unAsiento));
	}
	@Test
	public void unUsuarioNoRegistradoCompraUnoDeLosVuelos(){
		UsuarioConRecargo unUsuario = new UsuarioConRecargo();
		Vuelo unVuelo = new Vuelo();
		Asiento unAsiento = new Asiento();
		unAsiento.setDisponibilidad("D");
		unUsuario.compraAsiento(unAsiento, unVuelo);
		Assert.assertTrue(unVuelo.yaNoEstasDisponible(unAsiento));
	}
	@Test
	public void unUsuarioEstandarRealizaUnaBusqueda(){
		UsuarioEstandar unUsuario = new UsuarioEstandar();
		Collection<Busqueda> historialAntesDeLaBusqueda = unUsuario.getHistorial();
		unUsuario.buscar("LA", "BUE", "20121210", "20121211");
		Assert.assertNotSame(historialAntesDeLaBusqueda, unUsuario.getHistorial());
	}

}

