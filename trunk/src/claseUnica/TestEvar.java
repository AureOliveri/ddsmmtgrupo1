package claseUnica;

import junit.framework.Assert;

import org.junit.Test;

public class TestEvar {
	@Test
	public void tieneFormatoLatinoamericano(){
		Fecha fecha = new Fecha("27/03/1991");
		System.out.println(fecha.getAnio());
		Assert.assertTrue(fecha.getFormato().equals("Latinoamericano"));
	}
}


