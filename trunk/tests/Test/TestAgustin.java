package Test;

import junit.framework.Assert;

import org.junit.Test;

import Usuarios.Usuario;
import Usuarios.UsuarioEstandar;

import claseUnica.Fecha;
import claseUnica.parserException;

public class TestAgustin {
	@Test
	public void esElMismoDia() throws parserException{
		int deberiaSerCero;
		Fecha fecha1 = new Fecha("09-08-2000");
		Fecha fecha2 = new Fecha("08/09/2000");
		deberiaSerCero = fecha1.diferenciaDeDiasCon(fecha2);
		Assert.assertEquals(0, deberiaSerCero);
		System.out.println("Es el mismo dia, por q la diferencia de dias es: " + deberiaSerCero);
	
	}
	@Test
	public void esEstandar(){
	
		Usuario unUsuario = new UsuarioEstandar();
		String tipoDeUsuario = unUsuario.getTipoUsuario();
		System.out.println(tipoDeUsuario);
		Assert.assertEquals(tipoDeUsuario, "Estandar");
	}
	

}
