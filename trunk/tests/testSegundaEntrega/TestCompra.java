package testSegundaEntrega;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.Test;

import usuarios.UsuarioConRecargo;
import usuarios.UsuarioVIP;


public class TestCompra {
	
	@Test
	public void comprobarRecargo() {
		UsuarioConRecargo otroUsuario = new UsuarioConRecargo();
		BigDecimal recargo = otroUsuario.getRecargo();
		System.out.println(recargo);
		Assert.assertEquals("20", recargo.toString());
	}

	@Test
	public void aUnUsuarioConRecargoLeSaleMasCaroUnAsiento() {
		UsuarioVIP unUsuario = new UsuarioVIP();
		UsuarioConRecargo otroUsuario = new UsuarioConRecargo();

	}

}
