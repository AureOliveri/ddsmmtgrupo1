package testPrimerEntrega;

import org.junit.Assert;
import org.junit.Test;

import fechas.Fecha;
import fechas.parserException;



public class TestAurelio {
	@Test
	public void tieneFormatoNorteamericano() throws parserException{
		Fecha fecha1 = new Fecha("03- 29-  1991");
		Fecha fecha2 = new Fecha("02-29-2012");
		System.out.println("El formato de fecha 1 es: "+fecha1.getFormato());
		Assert.assertTrue(fecha1.getFormato().equals("Norteamericano"));
		System.out.println("El formato de fecha 2 es: "+fecha2.getFormato());
		Assert.assertTrue(fecha1.getFormato().equals("Norteamericano"));
	}
	
}
