package TestTDD;

import junit.framework.Assert;

import org.junit.Test;

import Usuarios.UsuarioVIP;
import Vuelos.Vuelo;

public class TDD {
	@Test
	public void unUsuarioVIPCompraUnoDeLosVuelos(){
		UsuarioVIP unUsuario = new UsuarioVIP();
		Vuelo unVuelo = new Vuelo();
		unUsuario.compraVuelo(unVuelo);
		Assert.assertFalse(unVuelo.estaDisponible());
		
	}
	
	
}
