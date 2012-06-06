package TestTDD;

import junit.framework.Assert;

import org.junit.Test;

import Usuarios.*;
import Vuelos.Vuelo;

public class TDD {
	@Test
	public void unUsuarioVIPCompraUnoDeLosVuelos(){
		UsuarioVIP unUsuario = new UsuarioVIP();
		Vuelo unVuelo = new Vuelo();
		unUsuario.compraVuelo(unVuelo);
		Assert.assertFalse(unVuelo.estaDisponible());
		
	}
	public void unUsuarioEstandarCompraUnoDeLosVuelos(){
		UsuarioEstandar unUsuario = new UsuarioEstandar();
		Vuelo unVuelo = new Vuelo();
		unUsuario.compraVuelo(unVuelo);
		Assert.assertFalse(unVuelo.estaDisponible());
	}
	public void unUsuarioNoRegistradoCompraUnoDeLosVuelos(){
		UsuarioNoRegistrado unUsuario = new UsuarioNoRegistrado();
		Vuelo unVuelo = new Vuelo();
		unUsuario.compraVuelo(unVuelo);
		Assert.assertFalse(unVuelo.estaDisponible());
	}


}

