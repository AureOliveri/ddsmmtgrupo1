package Test;

import junit.framework.Assert;

import org.junit.Test;

import claseUnica.Fecha;

public class TestAgustin {
	@Test
	public void esElMismoDia(){
		int deberiaSerCero;
		Fecha fecha1 = new Fecha("23-09-2000");
		Fecha fecha2 = new Fecha("08/23/2000");
		deberiaSerCero = fecha1.diferenciaDeDiasCon(fecha2);
		System.out.println("Es el mismo dia, por q la diferencia de dias es: " + deberiaSerCero);
		Assert.assertEquals(0, deberiaSerCero);
		
	
	}
}
